package com.harleylizard.script;

import com.harleylizard.script.query.Query;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class ScriptTest {

    @Test
    public void test() throws IOException {
        var resourceLoader = new ResourceLoader() {

            @Override
            public InputStream getResource(String path) throws IOException {
                return Resources.getResource(path);
            }
        };

        var scriptLoader = ScriptLoader.of(resourceLoader, List.of("test.script", "test2.script"));

        var internals = scriptLoader.getScript("test.script").getInternals();
        if (internals.hasData(scriptLoader, "bone")) {
            var data = internals.getData(scriptLoader, "bone");

            var query = new Query();
            var head = query.add("head", data);
            var body = query.add("body", data);

        }
    }
}
