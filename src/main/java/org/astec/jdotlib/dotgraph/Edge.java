/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph;

import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.astec.jdotlib.dotgraph.attributes.types.EdgeOp;

/**
 * org.astec.jdotlib.dotgraph
 * jDotlib
 * Created by alekum on 03.08.15 21:08.
 */

public class Edge
{
    private Node startNode;
    private Node finishedNode;
    private Attributes edgeAttributes;

    public Edge()
    { this( null, null, null ); }

    public Edge(Node started, Node finished)
    {
        this( started, finished, null );
    }

    public Edge(Node started, Node finished, Attributes attrs)
    {
        this.startNode = started;
        this.finishedNode = finished;
        this.edgeAttributes = attrs;
    }

    public Node getStartNode()
    {
        return this.startNode;
    }

    public Node getFinishedNode()
    {
        return this.finishedNode;
    }

    public void setStartNode( Node start )
    {
        this.startNode = start;
    }

    public void setFinishedNode( Node finished )
    {
        this.finishedNode = finished;
    }

    @Override
    public String toString()
    {
        return String.format( "%s %s %s %s;",
                              this.startNode.getNodeId(),
                              EdgeOp.DIRECTED, // TODO : need change this property
                              this.finishedNode.getNodeId(),
                              this.edgeAttributes.toString());
    }
}
