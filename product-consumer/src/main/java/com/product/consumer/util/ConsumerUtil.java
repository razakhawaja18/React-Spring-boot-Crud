package com.product.consumer.util;

import java.text.MessageFormat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumerUtil {

    private ConsumerUtil() {
    }

    public static String getParametrizeString(String url, String param) {
        log.info("In ProductConsumerUtil -> getParametrizeString() Called | url {}, param {}", url, param);
        return MessageFormat.format(url, param);
    }
}
