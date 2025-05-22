package kz.kenzhakhimov.transactionmicroservice.services;

import kz.kenzhakhimov.transactionmicroservice.entities.Transaction;
import kz.kenzhakhimov.transactionmicroservice.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final RabbitTemplate rabbitTemplate;

    @Transactional
    public Transaction addTransaction(Transaction transaction){
        transaction.setDate(LocalDateTime.now());
        rabbitTemplate.convertAndSend("massExchange", "", transaction);
        Transaction resp = transactionRepository.save(transaction);
        log.info("сообщение было доставлено в очередь");
        return resp;
    }
}
