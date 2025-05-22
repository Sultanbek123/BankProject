package kz.kenzhakhimov.analiticmicroservice.repositories;

import kz.kenzhakhimov.analiticmicroservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}