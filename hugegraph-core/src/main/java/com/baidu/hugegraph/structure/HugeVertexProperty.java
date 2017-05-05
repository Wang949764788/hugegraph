package com.baidu.hugegraph.structure;

import java.util.Iterator;

import org.apache.tinkerpop.gremlin.structure.Property;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.VertexProperty;

import com.baidu.hugegraph.HugeException;
import com.baidu.hugegraph.type.HugeTypes;
import com.baidu.hugegraph.type.schema.PropertyKey;

public class HugeVertexProperty<V> extends HugeProperty<V> implements VertexProperty<V> {

    public HugeVertexProperty(HugeElement owner, PropertyKey key, V value) {
        super(owner, key, value);
    }

    @Override
    public HugeTypes type() {
        return HugeTypes.VERTEX_PROPERTY;
    }

    @Override
    public Object id() {
        return this.key();
    }

    @Override
    public <V> Property<V> property(String key, V value) {
        throw new HugeException("Not support nested property");
    }

    @Override
    public Vertex element() {
        return (Vertex) super.element();
    }

    @Override
    public <U> Iterator<Property<U>> properties(String... propertyKeys) {
        throw new HugeException("Not support nested property");
    }
}