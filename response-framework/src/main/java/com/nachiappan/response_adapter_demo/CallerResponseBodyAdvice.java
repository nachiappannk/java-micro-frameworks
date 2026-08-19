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
        var a = 4;

        System.out.println("=== MethodParameter dump ===");
        System.out.println("toString           = " + returnType);
        System.out.println("method             = " + returnType.getMethod());
        System.out.println("containingClass    = " + returnType.getContainingClass());
        System.out.println("declaringClass     = " + returnType.getDeclaringClass());
        System.out.println("parameterType      = " + returnType.getParameterType());
        // System.out.println("type               = " + returnType.getType());
        System.out.println("nestedType         = " + returnType.getNestedParameterType());
        System.out.println("genericType        = " + returnType.getGenericParameterType());
        System.out.println("parameterName      = " + returnType.getParameterName());
        System.out.println("executable         = " + returnType.getExecutable());
        // System.out.println("annotations        = " + java.util.Arrays.toString(returnType.getAnnotations()));
        System.out.println("methodAnnotations  = " + java.util.Arrays.toString(returnType.getMethodAnnotations()));
        System.out.println("parameterAnnotations = " + java.util.Arrays.toString(returnType.getParameterAnnotations()));
        System.out.println("hasGetMapping      = " + returnType.hasMethodAnnotation(org.springframework.web.bind.annotation.GetMapping.class));
        System.out.println("hasRequestMapping  = " + returnType.hasMethodAnnotation(org.springframework.web.bind.annotation.RequestMapping.class));
        System.out.println("converterType      = " + converterType);
        System.out.println("=== end ===");
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
