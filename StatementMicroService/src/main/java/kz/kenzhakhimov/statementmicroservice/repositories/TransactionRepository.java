package kz.kenzhakhimov.statementmicroservice.repositories;

import kz.kenzhakhimov.statementmicroservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
