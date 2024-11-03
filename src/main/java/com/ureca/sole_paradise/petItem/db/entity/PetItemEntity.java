package com.ureca.sole_paradise.petItem.db.entity;

import com.ureca.sole_paradise.user.db.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class PetItemEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petItemId;

    @Column(nullable = false)
    private String name;

    @Column(
            nullable = false,
            name = "\"description\"",
            columnDefinition = "longtext"
    )
    private String description;

    @Column(columnDefinition = "longtext")
    private String imageUrl;

    @Column
    private Integer status;

    @Column
    private Integer price;

    @Column
    private Integer good;

    @Column
    private Integer sharing;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    @Column
    private String nanum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;



    @OneToMany(mappedBy = "petItem")
    private Set<PetItemCommentEntity> petItemPetItemComments;

}
