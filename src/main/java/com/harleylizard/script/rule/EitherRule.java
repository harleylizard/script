package com.harleylizard.script.rule;

import com.harleylizard.script.Grammar;
import com.harleylizard.script.Traverser;
import com.harleylizard.script.node.Node;

public final class EitherRule implements Rule {
    private final Rule left;
    private final Rule right;

    public EitherRule(Rule left, Rule right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void check(Grammar grammar, Traverser<Node> traverser) {
        try {
            right.check(grammar, traverser);
        } catch (Exception e) {
            left.check(grammar, traverser);
        }
    }
}
