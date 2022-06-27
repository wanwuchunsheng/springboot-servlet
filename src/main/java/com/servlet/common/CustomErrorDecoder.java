package com.servlet.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

/**
 * 自定义feign异常返回，接收三方接口异常返回
 * 
 * 
 * */
@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        Exception exception;
        try {
            String json = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            //自定义处理
            exception = new RuntimeException(json);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            exception = new RuntimeException("解析异常");
        }
        return exception;
    }

}
