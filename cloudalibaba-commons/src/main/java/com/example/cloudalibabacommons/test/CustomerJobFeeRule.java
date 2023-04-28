package com.example.cloudalibabacommons.test;

import lombok.Data;

/**
 * @author: liaozhenyu
 * @date: 2022/04/24
 **/
@Data
public class CustomerJobFeeRule {
    private Integer commissionFeePercent;
    private Integer commissionFeeType;
    private Integer commissionSaleAmountFrom;
    private Integer commissionSaleAmountTo;
    private Integer nodeGrossType;
    private Integer platformFeeAmount;
    private Integer platformFeePercent;
    private Integer platformFeeType;
    private Integer saleAmountFrom;
    private Integer saleAmountTo;

}
