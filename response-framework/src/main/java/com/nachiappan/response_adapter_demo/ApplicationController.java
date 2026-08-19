package com.nachiappan.response_adapter_demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @GetMapping("/connection")
    public Map<String, Object> connection() {
        Map<String, Object> connectionInfo = new HashMap<>();
        connectionInfo.put("status", "connected");
        connectionInfo.put("protocol", "http");
        connectionInfo.put("host", "localhost");
        connectionInfo.put("port", 8080);
        connectionInfo.put("environment", "dummy");
        return connectionInfo;
    }
}
