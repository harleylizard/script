package com.harleylizard.script;

import java.io.InputStream;

public interface ResourceLoader {

    InputStream getResource(String path);
}
