package kz.kenzhakhimov.transactionmicroservice.repositories;

import kz.kenzhakhimov.transactionmicroservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
