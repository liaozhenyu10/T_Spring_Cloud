package com.example.uploadfile8801.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:
 * @Author: chelsen
 * @Date: 2020/12/1
 **/

public class SignUtil {

    private static Logger logger = LoggerFactory.getLogger(SignUtil.class);

    public static boolean verifySign(BaseRequest baseRequest, String appSecret) {
        String signStr = sign(baseRequest, appSecret);
        return signStr.equalsIgnoreCase(baseRequest.getSign());
    }

    public static String sign(BaseRequest baseRequest, String appSecret) {
        StringBuffer content = new StringBuffer();
        content.append(baseRequest.getAppKey())
                .append(appSecret)
                .append(baseRequest.getInterfaceName())
                .append(baseRequest.getTimestamp())
                .append(baseRequest.getAppKey())
                .append(baseRequest.getData());

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("签名前字符串: "+content);
        md.update(content.toString().getBytes());
        byte[] digest = md.digest();

        String signStr = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        System.out.println("签名结果: "+signStr);
        logger.debug("签名结果: {}", signStr);
        return signStr;
    }

    public static void main(String[] args) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setInterfaceName("inboundVerification");
        baseRequest.setAppKey("youbao_cmcc_magic");
        baseRequest.setTimestamp(1657708300751L);
        baseRequest.setData("{\"express_number\":\"SF12345678\",\"mother_express_number\":\"SF12345677\",\"signfor_code\":\"9527\"}");
        baseRequest.setSign("11AFC892791CF20020721F97C7230B59");

        SignUtil.sign(baseRequest, "02b55bd22f844e2fbff6bda220f36744");
    }
}
