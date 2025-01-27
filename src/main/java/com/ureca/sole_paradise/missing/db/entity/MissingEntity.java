/*package com.ureca.sole_paradise.missing.db.entity;

import java.time.OffsetDateTime;

import com.ureca.sole_paradise.pet.db.entity.PetEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class MissingEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer missingId;

    @Column(nullable = false, length = 100)
    private String alarmName;

    @Column(nullable = false, length = 100)
    private String location;

    @Column
    private Integer alertRadiusKm;

    @Column(nullable = false)
    private OffsetDateTime missingDate;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    @Column(nullable = false, length = 2000)
    private String missingDetails;

    @Column
    private Integer missingStatus;

    @Column(nullable = false, columnDefinition = "longtext")
    private String alarmPicture;

    @Column(nullable = false, columnDefinition = "tinyint", length = 1)
    private Boolean contactNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", nullable = false)
    private PetEntity pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walkroute_id", nullable = false)
    private WalkRoute walkroute;

}*/