package com.nachiappan.response_adapter_demo;

public class CallerAdapterRegistry {

    public void register(String caller, ResponseAdapter<Object> adapter) {
        // No runtime adaptation is required; controller responses are returned as-is.
    }

    public Object adapt(Object body, String caller) {
        return body;
    }
}
