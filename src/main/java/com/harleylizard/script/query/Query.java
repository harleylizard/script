package com.harleylizard.script.query;

import com.harleylizard.script.entry.DataEntry;

import java.util.HashMap;
import java.util.Map;

public final class Query {

    private Query() {}

    public static final class Builder {
        private final Map<String, DataEntry.Instance> map = new HashMap<>();

        public Builder add(String name, DataEntry dataEntry) {
            map.put(name, dataEntry.create());
            return this;
        }
    }
}
