package com.nachiappan.response_adapter_demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class CallerResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final CallerAdapterRegistry registry;

    public CallerResponseBodyAdvice(CallerAdapterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                 MethodParameter returnType,
                                 MediaType selectedContentType,
                                 Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                 ServerHttpRequest request,
                                 ServerHttpResponse response) {
        if (body == null || !(request instanceof ServletServerHttpRequest servletRequest)) {
            return body;
        }

        HttpServletRequest httpRequest = servletRequest.getServletRequest();
        String caller = httpRequest.getParameter("caller");
        if (caller == null || caller.isBlank()) {
            return body;
        }

        return registry.adapt(body, caller);
    }
}
