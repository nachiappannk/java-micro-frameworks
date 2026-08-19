package com.nachiappan.response_adapter_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseFrameworkConfig {

    @Bean
    public CallerAdapterRegistry callerAdapterRegistry() {
        CallerAdapterRegistry registry = new CallerAdapterRegistry();

        registry.register("mobile-app", (body, context) -> {
            if (body instanceof ConnectionResponse connectionResponse) {
                connectionResponse.setCaller(context.getCaller());
                connectionResponse.setEnhanced(true);
                connectionResponse.setDisplayMode("mobile");
                connectionResponse.setProtocol(connectionResponse.getProtocol() + "-secure");
            }
            return body;
        });

        registry.register("web-portal", (body, context) -> {
            if (body instanceof ConnectionResponse connectionResponse) {
                connectionResponse.setCaller(context.getCaller());
                connectionResponse.setEnhanced(true);
                connectionResponse.setDisplayMode("web");
                connectionResponse.setHost("portal." + connectionResponse.getHost());
            }
            return body;
        });

        return registry;
    }
}
