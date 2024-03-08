package com.harleylizard.script;

import com.harleylizard.script.enums.Keyword;
import com.harleylizard.script.node.EnumNode;
import com.harleylizard.script.node.IdentifierNode;
import com.harleylizard.script.node.Node;
import com.harleylizard.script.rule.Rule;
import com.harleylizard.script.tree.ListTree;
import com.harleylizard.script.tree.MapTree;
import com.harleylizard.script.tree.ObjectTree;
import com.harleylizard.script.tree.Tree;

import java.util.*;

public final class Grammar {
    private final Map<String, Rule> map;

    private Grammar(Map<String, Rule> map) {
        this.map = map;
    }

    public void tryCheck(List<Node> list) {
        map.get("root").check(this, Traverser.of(list));
    }

    public MapTree toTree(List<Node> list) {
        var traverser = Traverser.of(list);

        var map = new HashMap<String, Tree>();
        var imports = new ArrayList<String>();
        while (traverser.hasNext()) {
            var node = traverser.current();
            if (node instanceof EnumNode<?> enumNode) {
                var j = enumNode.get();
                if (j == Keyword.IMPORT) {
                    traverser.next();
                    imports.add(((IdentifierNode) traverser.current()).getIdentifier());
                }
            }
            traverser.next();
        }
        map.put("imports", new ListTree<>(Collections.unmodifiableList(imports)));
        return new MapTree(Collections.unmodifiableMap(map));
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
