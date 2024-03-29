package com.harleylizard.script.rule;

import com.harleylizard.script.Grammar;
import com.harleylizard.script.Traverser;
import com.harleylizard.script.node.Node;

public final class OptionalRule implements Rule {
    private final Rule rule;

    public OptionalRule(Rule rule) {
        this.rule = rule;
    }

    @Override
    public void check(Grammar grammar, Traverser<Node> traverser) {
        try {
            rule.check(grammar, traverser);
        } catch (Exception e) {
        }
    }
}
