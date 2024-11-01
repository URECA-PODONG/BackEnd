package com.ureca.sole_paradise.payments.db.entity;

import com.ureca.sole_paradise.user.db.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "payments")
@Getter
@Builder
public class PaymentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer merchantId;

    private String pg;
    private Integer payAmount;
    private String payMethod;
    private String payName;

    private String impUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Setter
    private String payStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String cardName;
    private String cardNumber;
    private int installmentMonths;
    private String approvalNumber;
}
