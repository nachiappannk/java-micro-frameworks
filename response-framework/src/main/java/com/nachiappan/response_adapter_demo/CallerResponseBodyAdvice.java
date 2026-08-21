package com.nachiappan.response_adapter_demo;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.net.URI;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CallerResponseBodyAdvice implements ResponseBodyAdvice<Object> {

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
        if (!(body instanceof ConnectionResponse original)) {
            return body;
        }

        // Extract simple values and pass them to the adapter (avoid passing request objects)
        String method = request.getMethod() == null ? null : request.getMethod().name();
        URI uri = request.getURI();
        String url = uri == null ? null : uri.toString();
        String domain = uri == null ? null : uri.getHost();

        Map<String, List<String>> headers = new HashMap<>();
        request.getHeaders().forEach((k, v) -> headers.put(k, new ArrayList<>(v)));

        AdaptedConnectionResponse adapted = ConnectionResponseAdapter.adapt(original, method, url, domain, headers);
        return adapted;
    }
}
