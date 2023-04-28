package com.example.druid8082.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
