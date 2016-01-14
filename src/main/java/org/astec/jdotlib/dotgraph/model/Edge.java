/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attributes;

/**
 * org.astec.jdotlib.dotgraph
 * jDotlib
 * Created by alekum on 03.08.15 21:08.
 */

public class Edge<T extends Node>
{
    private T source;
    private T target;
    private Attributes edgeAttributes;

    public Edge(T started, T finished)
    {
        this( started, finished, new Attributes() );
    }

    public Edge(T started, T finished, Attributes attrs)
    {
        if(started == null || finished == null)
            throw new IllegalArgumentException("Node must not be null");

        this.source = started;
        this.target = finished;
        this.edgeAttributes = attrs;
    }

    public T getSource()
    {
        return this.source;
    }

    public T getTarget()
    {
        return this.target;
    }

    public void setSource(T start )
    {
        if(start == null)
            throw new IllegalArgumentException("Node must not be null");

        this.source = start;
    }

    public void setTarget(T finished )
    {
        if(finished == null)
            throw new IllegalArgumentException("Node must not be null");

        this.target = finished;
    }

    public Attributes getEdgeAttributes()
    {
        return this.edgeAttributes;
    }

    public void setEdgeAttributes(Attributes attrs)
    {
        this.edgeAttributes = attrs;
    }

    @Override
    public String toString()
    {
        return String.format("%s%s%s%s;",
                             this.source.getNodeId(),
                             " -> ", // TODO : need change this property
                             this.target.getNodeId(),
                             this.edgeAttributes.toString());
    }

    @Override
    public boolean equals(Object obj)
    {
        if(super.equals(obj))
            return true;

        if(!(obj instanceof Edge))
            return false;

        Edge e = (Edge) obj;

        return this.source.equals(e.getSource())
                && this.target.equals(e.getTarget());
    }
}
