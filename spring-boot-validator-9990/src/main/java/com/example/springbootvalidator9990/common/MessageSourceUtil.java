package com.example.springbootvalidator9990.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * @author: liaozhenyu
 * @date: 2022/09/27
 **/

@Component
public class MessageSourceUtil {

    private static MessageSource messageSource;

    private volatile static MessageSourceAccessor messageSourceAccessor;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        MessageSourceUtil.messageSource = messageSource;
    }

    public static MessageSourceAccessor getAccessor() {
        if (messageSourceAccessor == null) {
            synchronized (MessageSourceUtil.class) {
                if (messageSourceAccessor == null) {
                    messageSourceAccessor = new MessageSourceAccessor(messageSource);
                }
            }
        }
        return messageSourceAccessor;
    }
}
