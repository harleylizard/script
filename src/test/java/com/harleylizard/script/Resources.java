package com.harleylizard.script;

import java.io.IOException;
import java.io.InputStream;

public final class Resources {

    private Resources() {}

    public static InputStream getResource(String name) throws IOException {
        return Resources.class.getClassLoader().getResource(name).openStream();
    }
}
