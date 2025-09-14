package com.julianne.pets.controllers;

import com.julianne.pets.dtos.TransferDTO;
import com.julianne.pets.services.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    private final TransferService transferService;

    public BankController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferDTO transferDTO) {
        return transferService.execute(transferDTO);
    }
}
