package com.nachiappan.response_adapter_demo;

import java.util.List;
import java.util.Map;

/**
 * Adapter that produces an AdaptedConnectionResponse from a ConnectionResponse
 * and simple request-derived inputs (method, url, domain, headers).
 */
public class ConnectionResponseAdapter {

    public static AdaptedConnectionResponse adapt(ConnectionResponse original,
                                                  String method,
                                                  String url,
                                                  String domain,
                                                  Map<String, List<String>> headers) {
        AdaptedConnectionResponse a = new AdaptedConnectionResponse();
        if (original == null) return a;

        a.setStatus(original.getStatus());
        a.setProtocol(original.getProtocol());
        a.setHost(original.getHost());
        a.setPort(original.getPort());
        a.setEnvironment(original.getEnvironment());
        // preserve original caller if present
        a.setCaller(original.getCaller());
        a.setEnhanced(true);
        a.setDisplayMode("generic");

        // store request-derived values
        a.setRequestMethod(method);
        a.setRequestUrl(url);
        a.setRequestDomain(domain);
        a.setHeaders(headers);

        // headerCount: total number of header values across all header names
        int headerCount = 0;
        boolean hasAuth = false;
        if (headers != null) {
            for (String k : headers.keySet()) {
                java.util.List<String> vals = headers.get(k);
                if (vals != null) headerCount += vals.size();
                if (k != null && k.equalsIgnoreCase("Authorization")) {
                    hasAuth = true;
                }
            }
        }
        a.setHeaderCount(headerCount);
        a.setHasAuthHeader(hasAuth);

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
}
