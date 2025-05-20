package kz.kenzhakhimov.transactionmicroservice.repositories;

import kz.kenzhakhimov.transactionmicroservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
