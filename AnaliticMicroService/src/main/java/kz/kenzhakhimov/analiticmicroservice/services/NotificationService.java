package kz.kenzhakhimov.analiticmicroservice.services;

import kz.kenzhakhimov.analiticmicroservice.entities.Transaction;
import kz.kenzhakhimov.analiticmicroservice.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final TransactionRepository transactionRepository;
    @RabbitListener(queues = "analiticQueue")
    public void getNotification(Transaction transaction){
        transactionRepository.save(transaction);
        log.info("Message has been extracted from AnaliticQueue" + transaction);
    }
}
