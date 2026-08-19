package com.nachiappan.response_adapter_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @GetMapping("/connection")
    public ConnectionResponse connection() {
        ConnectionResponse connectionResponse = new ConnectionResponse();
        connectionResponse.setStatus("connected");
        connectionResponse.setProtocol("http");
        connectionResponse.setHost("localhost");
        connectionResponse.setPort(8080);
        connectionResponse.setEnvironment("dummy");
        return connectionResponse;
    }
}
