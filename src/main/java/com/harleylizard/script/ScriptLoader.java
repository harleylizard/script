package com.harleylizard.script;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ScriptLoader {
    private final Map<String, Script> map;

    private ScriptLoader(Map<String, Script> map) {
        this.map = map;
    }

    public boolean has(String path) {
        return map.containsKey(path);
    }

    public Script getScript(String path) {
        return map.get(path);
    }

    public static ScriptLoader of(ResourceLoader resourceLoader, List<String> paths) throws IOException {
        var map = new HashMap<String, Script>();

        for (var path : paths) {
            map.put(path, Script.parse(resourceLoader.getResource(path)));
        }
        return new ScriptLoader(Collections.unmodifiableMap(map));
    }
}
