package com.harleylizard.script;

import com.harleylizard.script.enums.DataType;
import com.harleylizard.script.enums.Delimiter;
import com.harleylizard.script.enums.Keyword;
import com.harleylizard.script.enums.Operator;
import com.harleylizard.script.rule.Rule;
import com.harleylizard.script.tree.ListTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public final class Script {
    private static final Grammar GRAMMAR = createGrammar();

    private final ScriptInternals internals;

    private Script(ScriptInternals internals) {
        this.internals = internals;
    }

    public ScriptInternals getInternals() {
        return internals;
    }

    public static Script parse(InputStream inputStream) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {
            var parsed = Lexer.parse(reader);

            GRAMMAR.tryCheck(parsed);
            var internals = TreeParser.toTree(parsed);

            return new Script(internals);
        }
    }

    private static Grammar createGrammar() {
        var builder = new Grammar.Builder();

        var scope = Rule.of(Rule.identifier(), Rule.enumOf(Operator.EQUAlS), Rule.identifier());
        var function = Rule.of(Rule.enumOf(Keyword.FUNCTION), Rule.identifier(), Rule.enumOf(Delimiter.OPEN_CURLY_BRACKET), Rule.many(scope), Rule.enumOf(Delimiter.CLOSE_CURLY_BRACKET));

        var field = Rule.of(Rule.anyOf(DataType.values()), Rule.identifier());
        var data = Rule.of(Rule.enumOf(Keyword.DATA), Rule.identifier(), Rule.enumOf(Delimiter.OPEN_CURLY_BRACKET), Rule.many(field), Rule.enumOf(Delimiter.CLOSE_CURLY_BRACKET));

        var import_ = Rule.of(Rule.enumOf(Keyword.IMPORT), Rule.identifier());
        builder.add("root", Rule.of(Rule.many(import_), Rule.many(data), Rule.many(function)));

        return builder.build();
    }
}
