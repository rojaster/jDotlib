/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.astec.jdotlib.dotgraph.attributes.types.EdgeOp;

/**
 * org.astec.jdotlib.dotgraph
 * jDotlib
 * Created by alekum on 03.08.15 21:08.
 */

public class Edge<T extends Node>
{
    private T startNode;
    private T finishedNode;
    private Attributes edgeAttributes;

    public Edge(T started, T finished)
    {
        this( started, finished, new Attributes() );
    }

    public Edge(T started, T finished, Attributes attrs)
    {
        this.startNode = started;
        this.finishedNode = finished;
        this.edgeAttributes = attrs;
    }

    public T getStartNode()
    {
        return this.startNode;
    }

    public T getFinishedNode()
    {
        return this.finishedNode;
    }

    public void setStartNode( T start )
    {
        this.startNode = start;
    }

    public void setFinishedNode( T finished )
    {
        this.finishedNode = finished;
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
                             this.startNode.getNodeId(),
                             EdgeOp.DIRECTED, // TODO : need change this property
                             this.finishedNode.getNodeId(),
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

        return this.startNode.equals(e.getStartNode())
                && this.finishedNode.equals(e.getFinishedNode());
    }
}
