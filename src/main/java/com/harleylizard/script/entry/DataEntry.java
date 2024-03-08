package com.harleylizard.script.entry;

import com.harleylizard.script.enums.DataType;
import com.harleylizard.script.node.*;

import java.util.HashMap;
import java.util.Map;

public final class DataEntry implements Entry {
    private final Map<String, DataType> fields;

    private DataEntry(Map<String, DataType> fields) {
        this.fields = fields;
    }

    private DataType orThrow(String name) {
        if (!fields.containsKey(name)) {
            throw new RuntimeException("No field for %s".formatted(name));
        }
        return fields.get(name);
    }

    public Instance create() {
        return new Instance(this);
    }

    public static DataEntry of(Map<String, DataType> map) {
        return new DataEntry(map);
    }

    public static final class Instance {
        private final Map<String, Node> map = new HashMap<>();
        private final DataEntry entry;

        private Instance(DataEntry entry) {
            this.entry = entry;
        }

        public void setDouble(String name, double d) {
            var dataType = entry.orThrow(name);
            if (dataType != DataType.DOUBLE) {
                throw wrongDataType(name);
            }
            map.put(name, new DoubleNode(d));
        }

        public void setFloat(String name, float f) {
            var dataType = entry.orThrow(name);
            if (dataType != DataType.FLOAT) {
                throw wrongDataType(name);
            }
            map.put(name, new FloatNode(f));
        }

        public void setInt(String name, int i) {
            var dataType = entry.orThrow(name);
            if (dataType != DataType.INT) {
                throw wrongDataType(name);
            }
            map.put(name, new FloatNode(i));
        }

        public void setByte(String name, byte b) {
            var dataType = entry.orThrow(name);
            if (dataType != DataType.BYTE) {
                throw wrongDataType(name);
            }
            map.put(name, new FloatNode(b));
        }

        public double getDouble(String name) {
            var node = map.get(name);
            if (node instanceof DoubleNode doubleNode) {
                return doubleNode.getD();
            }
            throw wrongDataType(name);
        }

        public float getFloat(String name) {
            var node = map.get(name);
            if (node instanceof FloatNode floatNode) {
                return floatNode.getF();
            }
            throw wrongDataType(name);
        }

        public int getInt(String name) {
            var node = map.get(name);
            if (node instanceof IntNode intNode) {
                return intNode.getI();
            }
            throw wrongDataType(name);
        }

        public byte getByte(String name) {
            var node = map.get(name);
            if (node instanceof ByteNode byteNode) {
                return byteNode.getB();
            }
            throw wrongDataType(name);
        }

        private static RuntimeException wrongDataType(String name) {
            return new RuntimeException("Wrong DataType for %s".formatted(name));
        }
    }
}
