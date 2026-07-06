package com.example.notificationService.kafka.dto;

import com.example.notificationService.enums.transaction.Currency;
import com.example.notificationService.enums.transaction.TransactionDirection;
import com.example.notificationService.enums.transaction.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)// ignore files that are null when returning data to the account service
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceUpdateEvent {

    // core transactions used by account service
    private String accountNumber;
    private BigDecimal amount;
    private TransactionDirection transactionDirection; //CREDIT, DEBIT
    private TransactionStatus transactionStatus; //SUCCESS, FAILED etc
    private String reference;
    private Currency currency;


    // core transactions used by notification service
    private String email;
    private String firstName;
    private BigDecimal currentBalance;
    private String description;
}
