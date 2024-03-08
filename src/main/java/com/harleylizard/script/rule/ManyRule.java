package com.harleylizard.script.rule;

import com.harleylizard.script.Grammar;
import com.harleylizard.script.Traverser;
import com.harleylizard.script.node.Node;

public final class ManyRule implements Rule {
    private final Rule rule;

    public ManyRule(Rule rule) {
        this.rule = rule;
    }

    @Override
    public void check(Grammar grammar, Traverser<Node> traverser) {
        var copy = traverser.copy();
        copy.previous();
        while (copy.hasNext()) {
            try {
                rule.check(grammar, traverser);
            } catch (Exception e) {
            }
            copy.next();
        }
    }
}
