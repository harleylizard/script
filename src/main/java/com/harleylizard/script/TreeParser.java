package com.harleylizard.script;

import com.harleylizard.script.entry.DataEntry;
import com.harleylizard.script.enums.DataType;
import com.harleylizard.script.enums.Delimiter;
import com.harleylizard.script.enums.Keyword;
import com.harleylizard.script.node.EnumNode;
import com.harleylizard.script.node.IdentifierNode;
import com.harleylizard.script.node.Node;

import java.util.*;

public final class TreeParser {

    private TreeParser() {}

    public static ScriptInternals toTree(List<Node> list) {
        var traverser = Traverser.of(list);

        var imports = new ArrayList<String>();
        var data = new HashMap<String, DataEntry>();
        while (traverser.hasNext()) {
            var node = traverser.current();
            if (node instanceof EnumNode<?> enumNode) {
                var j = enumNode.get();
                if (j == Keyword.IMPORT) {
                    traverser.next();
                    imports.add(getIdentifier(traverser.current()));
                }

                if (j == Keyword.DATA) {
                    traverser.next();
                    var name = getIdentifier(traverser.current());
                    var fields = new HashMap<String, DataType>();

                    traverser.next();
                    traverser.next();
                    var k = traverser.current();
                    while (!((k = traverser.current()) instanceof EnumNode<?> enumNode1 && enumNode1.get() == Delimiter.CLOSE_CURLY_BRACKET)) {
                        var dataType = getDataType(k);

                        traverser.next();
                        var fName = getIdentifier(traverser.current());

                        fields.put(fName, dataType);

                        traverser.next();
                    }
                    var dataEntry = DataEntry.of(Collections.unmodifiableMap(fields));
                    data.put(name, dataEntry);
                }
            }
            traverser.next();
        }
        return new ScriptInternals(Collections.unmodifiableList(imports), Collections.unmodifiableMap(data), Map.of());
    }

    private static DataType getDataType(Object o) {
        return (DataType) ((EnumNode<?>) o).get();
    }

    private static String getIdentifier(Object o) {
        return ((IdentifierNode) o).getIdentifier();
    }
}
