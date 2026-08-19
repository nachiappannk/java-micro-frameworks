package com.nachiappan.response_adapter_demo;

public class CallerContext {

    private final String caller;

    public CallerContext(String caller) {
        this.caller = caller;
    }

    public String getCaller() {
        return caller;
    }

    public boolean is(String expectedCaller) {
        return expectedCaller != null && expectedCaller.equalsIgnoreCase(caller);
    }
}
