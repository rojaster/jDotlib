/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.attributes;


/**
 * org.astec.jdotlib.dotgraph.attributes
 * jDotlib
 * Created by alekum on 03.08.15 15:32.
 */
public class Attribute implements Comparable<Attribute>
{
    private String name;
    private String value;

    public Attribute(String name, String value)
    {
        if(name.isEmpty() || value.isEmpty())
            throw new IllegalArgumentException("Attribute name or/and value cannot be empty");

        this.name = name;
        this.value = value;
    }

    public String getAttributeName()
    {
        return this.name;
    }

    public String getAttributeValue()
    {
        return this.value;
    }

    @Override
    public String toString()
    {
        return String.format("%s=\"%s\";", this.name, this.value);
    }

    @Override
    public int compareTo(Attribute o)
    {
        if(this == o)
            return 0;

        return this.name.compareToIgnoreCase(o.getAttributeName())
                | this.value.compareToIgnoreCase(o.getAttributeValue());
    }
}
