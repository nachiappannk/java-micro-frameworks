package com.nachiappan.response_adapter_demo;

public interface ResponseAdapter<T> {

    T adapt(T body, CallerContext context);
}
