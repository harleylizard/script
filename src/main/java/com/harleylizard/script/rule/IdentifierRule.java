package com.harleylizard.script.rule;

import com.harleylizard.script.Grammar;
import com.harleylizard.script.Traverser;
import com.harleylizard.script.node.IdentifierNode;
import com.harleylizard.script.node.Node;

public final class IdentifierRule implements Rule {
    @Override
    public void check(Grammar grammar, Traverser<Node> traverser) {
        var current = traverser.current();
        if (current instanceof IdentifierNode) {
            traverser.next();
        } else {
            throw new RuntimeException("Expected identifier but got %s".formatted(current.toString()));
        }
    }
}
