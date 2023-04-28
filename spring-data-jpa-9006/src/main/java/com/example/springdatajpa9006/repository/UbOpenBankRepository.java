package com.example.springdatajpa9006.repository;

import com.example.springdatajpa9006.entity.UbOpenBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by pengzq on 2020-11-11
 */
@Repository
public interface UbOpenBankRepository extends JpaRepository<UbOpenBank,String>, JpaSpecificationExecutor {

}
