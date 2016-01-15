/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attribute;
import org.astec.jdotlib.dotgraph.attributes.Attributes;

/**
 * org.astec.jdotlib.dotgraph.attributes
 * jDotlib
 * Created by alekum on 03.08.15 21:07.
 */

public class Node implements Comparable<Node>
{
    private String nodeId;
    private Attributes attributes;

    public Node(String id)
    {
        this(id, new Attributes());
    }

    public Node(String id, Attributes attrs)
    {
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("Node Id must not be empty");

        this.nodeId = id;
        this.attributes = attrs;
    }

    public String getNodeId()
    {
        return this.nodeId;
    }

    public void setNodeId(String id)
    {
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("Node Id must not be null or empty!");

        this.nodeId = id;
    }

    public void addAttribute(Attribute attr)
    {
        this.attributes.addAttribute( attr.getAttributeName(), attr );
    }

    public void setAttributes(Attributes attrs)
    {
        this.attributes = attrs;
    }

    public Attributes getAttributes()
    {
        return this.attributes;
    }

    @Override
    public String toString()
    {
        return String.format( "%s%s;", this.nodeId, this.attributes.toString() );
    }

    @Override
    public int compareTo(Node o)
    {
        if(this == o)
            return 0;

        return this.nodeId.compareToIgnoreCase(o.getNodeId());
    }

    @Override
    public boolean equals(Object obj)
    {
        if(super.equals(obj))
            return true;

        if(!(obj instanceof Node))
            return false;

        return this.nodeId.equalsIgnoreCase(((Node)obj).getNodeId());
    }
}
