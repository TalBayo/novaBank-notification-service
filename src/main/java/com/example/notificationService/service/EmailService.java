package com.example.notificationService.service;

import com.example.notificationService.kafka.dto.BalanceUpdateEvent;
import com.example.notificationService.kafka.dto.UserRegistrationEvent;

public interface EmailService {

    void sendWelcomeEmail(UserRegistrationEvent event);

    void sendTransactionAlertEmail(BalanceUpdateEvent event);
}
