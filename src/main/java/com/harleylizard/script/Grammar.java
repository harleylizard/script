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

    public void check(List<Node> list) {
        var traverser = Traverser.of(list);

        map.get("root").check(this, traverser);
    }

    public static final class Builder {
        private final Map<String, Rule> map = new HashMap<>();

        public Builder add(String name, Rule rule) {
            map.put(name, rule);
            return this;
        }

        public Grammar build() {
            return new Grammar(Collections.unmodifiableMap(map));
        }
    }
}
