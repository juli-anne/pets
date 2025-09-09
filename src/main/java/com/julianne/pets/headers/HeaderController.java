package com.julianne.pets.headers;

import com.julianne.pets.entities.Pet;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false, defaultValue = "Europe") String region) {
        // this is a simple example
        // abstract this out into a service class

        return switch (region) {
            case "Europe" -> "Europe";
            case "Asia" -> "Asia";
            case "North America" -> "North America";
            case "South America" -> "South America";
            case "Australia" -> "Australia";
            case "Africa" -> "Africa";
            default -> "Region not supported";
        };
    }
    
    @GetMapping(value = "/header/pet", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Pet> getPet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Ara");
        pet.setType("cat");
        pet.setBreed("birman");
        pet.setAge(5);

        return ResponseEntity.ok(pet);
    }
}
