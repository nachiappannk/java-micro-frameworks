package com.nachiappan.response_adapter_demo;

public class ConnectionResponse {

    private String status;
    private String protocol;
    private String host;
    private int port;
    private String environment;
    private String caller;
    private boolean enhanced;
    private String displayMode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public boolean isEnhanced() {
        return enhanced;
    }

    public void setEnhanced(boolean enhanced) {
        this.enhanced = enhanced;
    }

    public String getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(String displayMode) {
        this.displayMode = displayMode;
    }
}
