package com.example.sagaservice.dsl;

import java.util.HashMap;
import java.util.Map;

public class SagaExecutionContext {

    private final String sagaId;
    private final Map<String, Object> data = new HashMap<>();

    public SagaExecutionContext(String sagaId) {
        this.sagaId = sagaId;
    }

    public String getSagaId() {
        return sagaId;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

}
