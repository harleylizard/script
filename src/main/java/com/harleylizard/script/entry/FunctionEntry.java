package com.harleylizard.script.entry;

import com.harleylizard.script.Traverser;
import com.harleylizard.script.query.Query;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntStack;

import java.util.List;

public final class FunctionEntry implements Entry {
    private final List<String> list;

    private FunctionEntry(List<String> list) {
        this.list = list;
    }

    public void execute(Query query) {
        var traverser = Traverser.of(list);

        IntStack numbers = new IntArrayList();
        IntStack operators = new IntArrayList();

        while (traverser.hasNext()) {
            var current = traverser.current();

            if (current.contains(".")) {
                var split = current.split("\\.");

                var instance = query.get(split[0]);

                traverser.next();
                var a = traverser.current();
                if (a.equals("=")) {
                    traverser.next();

                    var j = Float.parseFloat(traverser.current());

                    instance.setFloat(split[1], Float.parseFloat(traverser.current()));
                }
            }
            traverser.next();
        }
    }

    public static FunctionEntry of(List<String> list) {
        return new FunctionEntry(list);
    }
}
