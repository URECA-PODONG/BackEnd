package com.ureca.sole_paradise.community.db.entity;

import com.ureca.sole_paradise.user.db.entity.UserEntity;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
public class CommunityEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "longtext")
    private String contents;

    @Column
    private Integer good;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    @Column(length = 225)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

   // @OneToMany(mappedBy = "post")
   //private Set<CommunityComment> postCommunityComments;
}
