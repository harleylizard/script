package com.harleylizard.script;

import com.harleylizard.script.node.Node;
import com.harleylizard.script.rule.Rule;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Grammar {
    private final Map<String, Rule> map;

    private Grammar(Map<String, Rule> map) {
        this.map = map;
    }

    public void tryCheck(List<Node> list) {
        map.get("root").check(this, Traverser.of(list));
    }

    public static final class Builder {
        private final Map<String, Rule> map = new HashMap<>();

        public void add(String name, Rule rule) {
            map.put(name, rule);
        }

        public Grammar build() {
            return new Grammar(Collections.unmodifiableMap(map));
        }
    }
}
