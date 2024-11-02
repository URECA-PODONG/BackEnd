package com.ureca.sole_paradise.payments.service;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.ureca.sole_paradise.payments.db.entity.PaymentsEntity;
import com.ureca.sole_paradise.payments.db.repository.PaymentsRepository;
import com.ureca.sole_paradise.user.db.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentsService {

    private final IamportClient iamportClient;

    private final PaymentsRepository paymentsRepository;

    public void createPayLog(String impUid, int userId) throws IamportResponseException, IOException {

        IamportResponse<Payment> iamportResponse = iamportClient.paymentByImpUid(impUid);

        Payment payment = iamportResponse.getResponse();

        PaymentsEntity paymentEntity = PaymentsEntity.builder()
                .user(UserEntity.builder().userId(1).build())
                .pg(payment.getPgProvider())
                .createdAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                .updatedAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                .payAmount(payment.getAmount().intValue())
                .payStatus(payment.getStatus())
                .impUid(impUid)
                .cardName(payment.getCardName())
                .cardNumber(payment.getCardCode())
                .installmentMonths(payment.getCardQuota())
                .approvalNumber(payment.getApplyNum())
                .payMethod(payment.getPayMethod())
                .payName(payment.getName()).build();

        paymentsRepository.save(paymentEntity);

    }

    public List<PaymentsEntity> getPaymentList(int userId) {
        Pageable pageable = PageRequest.of(0, 10);
        Page<PaymentsEntity> paymentsEntityPage = paymentsRepository.findByUser_UserId(userId, pageable);
        return paymentsEntityPage.toList();
    }

    public void cancelPayLog(int id, String iamUid) throws IamportResponseException, IOException {
        Optional<PaymentsEntity> payments = paymentsRepository.findById(id);
        if (payments.isPresent()) {
            PaymentsEntity paymentsEntity = payments.get();
            paymentsEntity.setPayStatus(iamportClient.paymentByImpUid(iamUid).getResponse().getStatus());

            paymentsRepository.save(paymentsEntity);
        }

    }
}
