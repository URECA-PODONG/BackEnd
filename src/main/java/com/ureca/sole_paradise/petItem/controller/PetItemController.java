package com.ureca.sole_paradise.petItem.controller;

import com.ureca.sole_paradise.petItem.db.dto.PetItemDTO;
import com.ureca.sole_paradise.petItem.service.PetItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/pet/item")
@RequiredArgsConstructor
public class PetItemController {



    private final PetItemService petItemService;

    @PostMapping
    public ResponseEntity<?> uploadPet(@RequestBody PetItemDTO petItemDTO,
                                       @RequestPart(value = "imageUrl", required = false) MultipartFile file) {

        petItemService.uploadPet(petItemDTO, file);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
