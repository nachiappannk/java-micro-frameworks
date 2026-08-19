package com.nachiappan.response_adapter_demo;

import java.util.HashMap;
import java.util.Map;

public class CallerAdapterRegistry {

    private final Map<String, ResponseAdapter<Object>> adapters = new HashMap<>();

    public void register(String caller, ResponseAdapter<Object> adapter) {
        adapters.put(caller, adapter);
    }

    public Object adapt(Object body, String caller) {
        if (body == null || caller == null || caller.isBlank()) {
            return body;
        }

        ResponseAdapter<Object> adapter = adapters.get(caller);
        if (adapter == null) {
            return body;
        }

        return adapter.adapt(body, new CallerContext(caller));
    }
}
