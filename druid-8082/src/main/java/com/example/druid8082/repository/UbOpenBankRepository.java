package com.example.druid8082.repository;

import com.example.druid8082.entity.UbOpenBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface UbOpenBankRepository extends JpaRepository<UbOpenBank,String>, JpaSpecificationExecutor {

}
