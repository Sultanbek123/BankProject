package kz.kenzhakhimov.statementmicroservice.services;

import jakarta.persistence.Entity;
import kz.kenzhakhimov.statementmicroservice.entities.Transaction;
import kz.kenzhakhimov.statementmicroservice.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final TransactionRepository transactionRepository;
    @RabbitListener(queues = "myQueue")
    public void getNotification(Transaction transaction){
        transactionRepository.save(transaction);
        log.info("Message has been extracted" + transaction);
    }
}
