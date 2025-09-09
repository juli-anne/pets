package com.julianne.pets;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.exceptions.PetNotFoundException;
import com.julianne.pets.repositories.PetRepository;
import com.julianne.pets.services.GetPetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetPetServiceTest {

    @Mock // need this to run the test - we are mocking something
    private PetRepository petRepository;

    @InjectMocks // the thing we are testing
    private GetPetService getPetService;

    @BeforeEach // things we need before the test runs to set up properly
    public void setup() {
        // initialize the repository & the service class
        MockitoAnnotations.openMocks(this);
    }

    // write the test
    @Test
    public void given_pet_exists_when_get_pet_service_return_pet_dto() {

        // given - arrange
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Oni");
        pet.setType("dog");
        pet.setBreed("mixed");
        pet.setAge(8);

        // tells the petrepository to return what we tell it to during the duration of the test
        when(petRepository.findById(1)).thenReturn(Optional.of(pet));

        // when - act
        ResponseEntity<PetDTO> response = getPetService.execute(1);

        // then - assert
        assertEquals(ResponseEntity.ok(new PetDTO(pet)), response);
        // asserts  the petrepository was called only once
        verify(petRepository, times(1)).findById(1);

    }

    @Test
    public void given_pet_does_not_exists_when_get_pet_service_throw_pet_not_found_exception() {

        // given
        when(petRepository.findById(1)).thenReturn(Optional.empty());

        // when & then
        assertThrows(PetNotFoundException.class, () -> getPetService.execute(1));
        // executes the getpetservice method and catches the exception and asserts it was caught

        verify(petRepository, times(1)).findById(1);
    }
}
