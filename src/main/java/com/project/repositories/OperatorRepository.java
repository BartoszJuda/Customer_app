package com.project.repositories;

import com.project.models.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

    @Query("select o from Operator o where o.operatorName =?1")
    Operator findOperatorByOperatorName(String name);

    @Query("select o from Operator o where o.operatorName =?1")
    Optional<Operator> findOperatorByOperatorNameOptional(String name);

    @Query("select o from Operator o where o.id =?1")
    Operator findOperatorById(long id);
}
