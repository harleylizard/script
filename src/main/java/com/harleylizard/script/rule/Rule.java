package com.harleylizard.script.rule;

import com.harleylizard.script.Grammar;
import com.harleylizard.script.Traverser;
import com.harleylizard.script.node.Node;

import java.util.List;

public sealed interface Rule permits AnyOfRule, EitherRule, EnumRule, IdentifierRule, ManyRule, OptionalRule, SequenceRule {

    void check(Grammar grammar, Traverser<Node> traverser);

    static Rule of(Rule... rules) {
        return new SequenceRule(List.of(rules));
    }

    static <T extends Enum<T>> Rule enumOf(T t) {
        return new EnumRule<>(t);
    }

    static Rule either(Rule left, Rule right) {
        return new EitherRule(left, right);
    }

    static Rule many(Rule rule) {
        return new ManyRule(rule);
    }

    static Rule optional(Rule rule) {
        return new OptionalRule(rule);
    }

    static Rule identifier() {
        return new IdentifierRule();
    }

    static <T extends Enum<T>> Rule anyOf(T[] t) {
        return new AnyOfRule<>(t);
    }
}
