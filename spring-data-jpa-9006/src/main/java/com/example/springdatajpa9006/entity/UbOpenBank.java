package com.example.springdatajpa9006.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 银行联行号实体
 * Create by pengzq on 2020-11-10
 */
@Entity
@Table(name = "ub_open_bank")
@Data
@DynamicInsert
@DynamicUpdate
public class UbOpenBank {

    @Id
    @Column(name = "fd_id")
    private String fdId;

    @Column(name = "fd_bank_name")
    private String fdBankName;

    @Column(name = "fd_line_number")
    private String fdLineNumber;

}
