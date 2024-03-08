package com.harleylizard.script.tree;

import java.util.Map;

public final class MapTree implements Tree {
    private final Map<String, Tree> map;

    public MapTree(Map<String, Tree> map) {
        this.map = map;
    }

    public Tree get(String name) {
        return map.getOrDefault(name, ListTree.empty());
    }
}
