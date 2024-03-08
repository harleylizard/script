package com.harleylizard.script;

import com.harleylizard.script.enums.DataType;
import com.harleylizard.script.enums.Delimiter;
import com.harleylizard.script.enums.Keyword;
import com.harleylizard.script.node.EnumNode;
import com.harleylizard.script.node.IdentifierNode;
import com.harleylizard.script.node.Node;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Lexer {

    private Lexer() {}

    public static List<Node> parse(Reader reader) {
        var list = new ArrayList<Node>();

        var scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            list.add(createNode(scanner.next()));
        }
        return Util.toImmutable(list);
    }

    private static Node createNode(String s) {
        if (Delimiter.PATTERN.matcher(s).matches()) {
            return new EnumNode<>(Delimiter.get(s));
        }
        if (s.equals("byte") || s.equals("int") || s.equals("float") || s.equals("double")) {
            return new EnumNode<>(DataType.get(s));
        }
        if (s.equals("import") || s.equals("data") || s.equals("function")) {
            return new EnumNode<>(Keyword.get(s));
        }
        return new IdentifierNode(s);
    }
}
