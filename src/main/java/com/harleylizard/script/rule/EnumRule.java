package com.harleylizard.script.rule;

import com.harleylizard.script.Grammar;
import com.harleylizard.script.Traverser;
import com.harleylizard.script.node.EnumNode;
import com.harleylizard.script.node.Node;

public final class EnumRule<T extends Enum<T>> implements Rule {
    private final T t;

    public EnumRule(T t) {
        this.t = t;
    }

    @Override
    public void check(Grammar grammar, Traverser<Node> traverser) {
        if (traverser.current() instanceof EnumNode<?> enumNode) {
            var j = enumNode.get();
            if (t == j) {
                traverser.next();
            } else {
                throw new RuntimeException("Mismatch with EnumRule. Expected %s, got %s".formatted(t.name(), j.name()));
            }
        } else {
            throw new RuntimeException("Node is not a EnumNode");
        }
    }
}
