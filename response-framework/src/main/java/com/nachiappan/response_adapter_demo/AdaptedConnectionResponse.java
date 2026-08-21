package com.nachiappan.response_adapter_demo;

/**
 * AdaptedConnectionResponse is a wrapper/derived view of ConnectionResponse that
 * computes a few convenient properties (baseUrl, secure, hostLabel, portCategory)
 * and centralizes caller-based adaptation logic.
 */
public class AdaptedConnectionResponse {

    private String status;
    private String protocol;
    private String host;
    private int port;
    private String environment;
    private String caller;
    private boolean enhanced;
    private String displayMode;

    // Computed properties
    private String baseUrl;
    private boolean secure;
    private String hostLabel;
    private String portCategory;

    public static AdaptedConnectionResponse from(ConnectionResponse original) {
        AdaptedConnectionResponse a = new AdaptedConnectionResponse();
        if (original == null) return a;

        a.setStatus(original.getStatus());
        a.setProtocol(original.getProtocol());
        a.setHost(original.getHost());
        a.setPort(original.getPort());
        a.setEnvironment(original.getEnvironment());
        // preserve original caller if present, but do not base adaptations on it
        a.setCaller(original.getCaller());
        a.setEnhanced(true);
        a.setDisplayMode("generic");

        // computed properties derived solely from the original
        String proto = a.getProtocol() == null ? "" : a.getProtocol();
        String host = a.getHost() == null ? "" : a.getHost();
        int port = a.getPort();

        a.setBaseUrl(proto + "://" + host + ":" + port);
        a.setSecure(proto.toLowerCase().contains("https") || proto.toLowerCase().contains("secure"));
        a.setHostLabel(host + (a.getEnvironment() != null && !a.getEnvironment().isBlank() ? " (" + a.getEnvironment() + ")" : ""));
        a.setPortCategory(port > 0 && port < 1024 ? "privileged" : "ephemeral");

        return a;
    }

    // getters/setters for core properties
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }

    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }

    public String getCaller() { return caller; }
    public void setCaller(String caller) { this.caller = caller; }

    public boolean isEnhanced() { return enhanced; }
    public void setEnhanced(boolean enhanced) { this.enhanced = enhanced; }

    public String getDisplayMode() { return displayMode; }
    public void setDisplayMode(String displayMode) { this.displayMode = displayMode; }

    // getters/setters for computed properties
    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

    public boolean isSecure() { return secure; }
    public void setSecure(boolean secure) { this.secure = secure; }

    public String getHostLabel() { return hostLabel; }
    public void setHostLabel(String hostLabel) { this.hostLabel = hostLabel; }

    public String getPortCategory() { return portCategory; }
    public void setPortCategory(String portCategory) { this.portCategory = portCategory; }
}
