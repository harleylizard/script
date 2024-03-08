package com.harleylizard.script.rule;

import com.harleylizard.script.Grammar;
import com.harleylizard.script.Traverser;
import com.harleylizard.script.node.Node;

import java.util.List;

public final class SequenceRule implements Rule {
    private final List<Rule> list;

    public SequenceRule(List<Rule> list) {
        this.list = list;
    }

    @Override
    public void check(Grammar grammar, Traverser<Node> traverser) {
        for (var rule : list) {
            rule.check(grammar, traverser);
        }
    }
}
