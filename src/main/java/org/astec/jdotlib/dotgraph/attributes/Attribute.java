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

public class Attribute
{
    private String attribute;
    private String value;

    public Attribute(String attribute, String value)
    {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttributeName()
    {
        return this.attribute;
    }

    public String getAttributeValue()
    {
        return this.value;
    }

    @Override
    public String toString()
    {
        return String.format("%s=\"%s\";", this.attribute, this.value);
    }
}
