package com.learningjourney.journey.responsebodyadvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes != null) {
            HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

            // httpServletRequest.getRequestURI() 를 이용하여 원하는 API 에만 동작하도록 설정할 수 있다.
            String requestURI = httpServletRequest.getRequestURI();

            if ("/response-body-advice/object-to-string".equals(requestURI)) {
                return "SUCCESS";
            } else if ("/response-body-advice/string-to-object".equals(requestURI)) {
                return new CustomDto("SUCCESS");
            }
        }

        return body;
    }
}
