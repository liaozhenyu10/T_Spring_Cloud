package com.example.uploadfile8801.oa;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author: liaozhenyu
 * @date: 2022/04/25
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println((String) null);
        List<String> stringList = Arrays.asList("1", "3");
        System.out.println(stringList.contains("1"));

    }

    public static void main2(String[] args) {

        String str = "{\"remark\":\"sjfjdik报错的我是看金额无色的山地车科技\",\"uin\":\"YANGXINGXING\",\"customerPartyName\":\"合伙人sidy测试\",\"effective\":\"2022-12-28\",\"landlordCustomerCode\":\"NOT144391\",\"orgId\":\"1620\",\"uboxPartyName\":\"深圳友宝科斯科技有限公司\",\"securityType\":\"1\",\"createDate\":\"2022-04-28\",\"customerContactPhone\":\"18952103364\",\"usn\":\"杨星星\",\"customerContactName\":\"alods\",\"securityPhone\":\"15321401658\",\"sn\":\"2\",\"standard\":\"2\",\"vld\":\"2029-11-22\",\"uboxContactName\":\"fgdf\",\"businessType\":\"8\",\"tmpId\":\"2021122806\",\"uboxContactPhone\":\"16021458475\",\"fdId\":\"1806f86dd2df255cbb8dc5e45e0ae69a\",\"threePartContract\":\"2\",\"securityName\":\"bdsw\",\"contractName\":\"测试合同5p\"}";
        Map<String, String> paramMap = JSON.parseObject(str, Map.class);

String s2 = "[{\"commissionFeePercent\":\"200\",\"platformFeePercent\":\"300\",\"commissionSaleAmountFrom\":\"0\",\"commissionFeeType\":\"1\",\"saleAmountTo\":\"3600000\",\"platformFeeType\":\"1\",\"commissionSaleAmountTo\":\"860000\",\"nodeGrossType\":\"1\",\"saleAmountFrom\":\"0\"},{\"platformFeeAmount\":\"620000\",\"commissionFeePercent\":\"300\",\"commissionSaleAmountFrom\":\"860000\",\"commissionFeeType\":\"1\",\"saleAmountTo\":\"8610000\",\"platformFeeType\":\"2\",\"commissionSaleAmountTo\":\"1000000000\",\"nodeGrossType\":\"1\",\"saleAmountFrom\":\"3600000\"},{\"platformFeePercent\":\"700\",\"saleAmountTo\":\"1000000000\",\"platformFeeType\":\"1\",\"saleAmountFrom\":\"8610000\"}]";

String s1 = "{\"key1\":\"2022\",\"key2\":\"4\",\"key3\":\"28\",\"key4\":\"深圳友宝科斯科技有限公司\",\"key5\":\"sdfa测试个人\",\"key6\":\"MSDH23786KJDSF\",\"key7\":\"451201236548125479\",\"key8\":\"SDK解封后\",\"key9\":\"没表达式大美女奥施康定我的我\",\"key10\":\"werh/16521041354\",\"key11\":\"pegu/15022361489\",\"key12\":\"2022\",\"key13\":\"4\",\"key14\":\"28\",\"key15\":\"2028\",\"key16\":\"12\",\"key17\":\"29\"}";
        paramMap.put("tplData", s1);
        paramMap.put("jobFeeRuleList", s2);

        Map<String, List<HttpUtils.FileInfo>> fileInfoMap = new HashMap<>();

        List<HttpUtils.FileInfo> onlineFile = new ArrayList<>();
        List<HttpUtils.FileInfo> thirdPartFile = new ArrayList<>();
        List<HttpUtils.FileInfo> otherFile = new ArrayList<>();
        fileInfoMap.put("onlineFile", onlineFile);
        fileInfoMap.put("thirdPartFile", thirdPartFile);
        fileInfoMap.put("otherFile", otherFile);


        HttpUtils.FileInfo of = new HttpUtils.FileInfo();
        of.setFileName("在线1.doc");
        of.setFilePath("E:\\Downloads\\temp\\onlineFile.doc");
        onlineFile.add(of);

        HttpUtils.FileInfo of2 = new HttpUtils.FileInfo();
        of2.setFileName("在线2.doc");
        of2.setFilePath("E:\\Downloads\\temp\\onlineFile2.doc");
        onlineFile.add(of2);

        HttpUtils.FileInfo orf = new HttpUtils.FileInfo();
        orf.setFileName("其它1.doc");
        orf.setFilePath("E:\\Downloads\\temp\\otherFile.doc");
        otherFile.add(orf);

        HttpUtils.FileInfo orf2 = new HttpUtils.FileInfo();
        orf2.setFileName("其它2.doc");
        orf2.setFilePath("E:\\Downloads\\temp\\otherFile2.doc");
        otherFile.add(orf2);


        String threePartContract = paramMap.get("threePartContract");

        if ("2".equals(threePartContract)) {
            HttpUtils.FileInfo tf = new HttpUtils.FileInfo();
            tf.setFileName("三方.doc");
            tf.setFilePath("E:\\Downloads\\temp\\thirdPartFile.doc");
            thirdPartFile.add(tf);

            HttpUtils.FileInfo tf2 = new HttpUtils.FileInfo();
            tf2.setFileName("thirdPartFile2.doc");
            tf2.setFilePath("E:\\Downloads\\temp\\thirdPartFile2.doc");
            thirdPartFile.add(tf2);
        }

        String result = HttpUtils.upload("http://192.168.19.41:28081/oa/createContract", fileInfoMap, paramMap);

        System.out.println(result);

        System.out.println("end......");
    }
}
