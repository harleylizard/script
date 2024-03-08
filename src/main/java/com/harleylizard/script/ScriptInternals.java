package com.harleylizard.script;

import com.harleylizard.script.entry.DataEntry;
import com.harleylizard.script.entry.FunctionEntry;

import java.util.List;
import java.util.Map;

public final class ScriptInternals {
    private final List<String> imports;
    private final Map<String, DataEntry> data;
    private final Map<String, FunctionEntry> functions;

    public ScriptInternals(List<String> imports, Map<String, DataEntry> data, Map<String, FunctionEntry> functions) {
        this.imports = imports;
        this.data = data;
        this.functions = functions;
    }

    public boolean hasData(ScriptLoader loader, String name) {
        var twice = false;
        for (var anImport : imports) {
            if (!loader.has(anImport)) {
                throw new RuntimeException("Unable to find script for %s".formatted(anImport));
            }
            if (loader.getScript(anImport).getInternals().hasData(loader, name)) {
                twice = true;
                break;
            }
        }
        if (twice && data.containsKey(name)) {
            throw new RuntimeException("Duplicate data(s) of \"%s\"".formatted(name));
        }
        return twice || data.containsKey(name);
    }

    public DataEntry getData(ScriptLoader loader, String name) {
        for (var anImport : imports) {
            if (!loader.has(anImport)) {
                throw new RuntimeException("Unable to find script for %s".formatted(anImport));
            }
            return loader.getScript(anImport).getInternals().getData(loader, name);
        }
        return data.get(name);
    }

    public boolean hasFunction(String name) {
        return functions.containsKey(name);
    }

    public FunctionEntry getFunction(String name) {
        return functions.get(name);
    }
}
