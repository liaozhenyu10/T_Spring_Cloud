package com.example.cloudalibabacommons.test;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: liaozhenyu
 * @date: 2022/04/24
 **/
public class Test {

    public static void main(String [] args) {

        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }

//    public static void main(String[] args) {
//        List<CustomerJobFeeRule> customerJobFeeRules = new ArrayList();
//
//        customerJobFeeRules.sort((o1, o2) -> {
//            if (!o1.getCommissionSaleAmountFrom().equals(o2.getCommissionSaleAmountTo())) {
//                throw new BizException("区间填写错误");
//            }
//            return 0;
//        });
//        for (int index = 0; index < customerJobFeeRules.size(); index++) {
//            CustomerJobFeeRule s = customerJobFeeRules.get(index);
//            if (null != CommonUtil.val(s.getCommissionFeeType())) {
//                if (FeeType.PERCENT.equals(s.getCommissionFeeType())) {
//                    Assert.not  Null(s.getCommissionFeePercent(), "请输入分成百分比");
//                    if(s.getCommissionFeePercent() < 1){
//                        throw new BizException("分成百分比必须大于零");
//                    }
//                } else if (FeeType.CONTRACT_AMOUNT.equals(s.getCommissionFeeType())) {
//                    Assert.notNull(s.getCommissionFeeAmount(), "请输入分成金额");
//                }
//            }
////            Assert.notNull(s.getSaleAmountTo(), "请输入起始区间");
////            Assert.notNull(s.getSaleAmountFrom(), "请输入闭合区间");
//            if (s.getCommissionSaleAmountTo() <= s.getCommissionSaleAmountFrom()) {
//                throw new BizException("结束区间金额不能小于开始区间金额");
//            }
//            if (index + 1 == customerJobFeeRules.size()) {
//                if (s.getCommissionSaleAmountTo() != AMOUNT_INFINITY) {
//                    throw new BizException("金额结束区间应为正无穷");
//                }
//            } else if (index > 0) {
//
//                if (!s.getCommissionSaleAmountFrom().equals(customerJobFeeRules.get(index - 1).getCommissionSaleAmountTo())) {
//                    throw new BizException("上一条的结束区间金额应该等于下一条的开始区间金额!");
//                }
//
//                if (s.getCommissionSaleAmountFrom() == 0) {
//                    throw new BizException("请输入金额起始区间");
//                }
//
//                if (CommonUtil.isEmpty(s.getCommissionSaleAmountTo().intValue())) {
//                    throw new BizException("请输入金额结束区间");
//                }
//
//                if (s.getCommissionSaleAmountTo() >= AMOUNT_INFINITY) {
//                    throw new BizException("金额不正确");
//                }
//            } else {
//                if (s.getCommissionSaleAmountFrom() != 0) {
//                    throw new BizException("第一条规则起始金额应为0");
//                }
//            }
//        }
//    }
//    }
}
