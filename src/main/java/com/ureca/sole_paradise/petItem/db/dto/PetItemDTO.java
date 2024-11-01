package com.ureca.sole_paradise.petItem.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetItemDTO {

    private int petItemId;
    private String name;
    private String description;
    private String imageUrl;//사진
    private int status;
    private int price;
    private int good;
    private int sharing;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String nanum;// 나눔 여부??
    private int user;

}
