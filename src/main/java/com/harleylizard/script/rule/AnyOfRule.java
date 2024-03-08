package com.harleylizard.script.rule;

import com.harleylizard.script.Grammar;
import com.harleylizard.script.Traverser;
import com.harleylizard.script.node.EnumNode;
import com.harleylizard.script.node.Node;

public final class AnyOfRule<T extends Enum<T>> implements Rule {
    private final T[] t;

    public AnyOfRule(T[] t) {
        this.t = t;
    }

    @Override
    public void check(Grammar grammar, Traverser<Node> traverser) {
        var current = traverser.current();
        if (current instanceof EnumNode<?> enumNode) {
            var j = enumNode.get();
            for (var e : t) {
                if (j == e) {
                    traverser.next();
                    break;
                }
            }
        }
    }
}
