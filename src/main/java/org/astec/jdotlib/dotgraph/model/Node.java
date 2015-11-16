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

public class Node
{
    private String nodeId;
    private Attributes attributes;

    Node(String id)
    {
        this(id, new Attributes());
    }

    Node(String id, Attributes attrs)
    {
        this.nodeId = id;
        this.attributes = attrs;
    }

    public String getNodeId()
    {
        return this.nodeId;
    }

    public void setNodeId(String id)
    {
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
}
