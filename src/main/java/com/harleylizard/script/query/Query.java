package com.harleylizard.script.query;

import com.harleylizard.script.entry.DataEntry;

import java.util.HashMap;
import java.util.Map;

public final class Query {
    private final Map<String, DataEntry.Instance> map = new HashMap<>();

    public DataEntry.Instance add(String name, DataEntry entry) {
        var instance = entry.create();
        map.put(name, instance);
        return instance;
    }
}
