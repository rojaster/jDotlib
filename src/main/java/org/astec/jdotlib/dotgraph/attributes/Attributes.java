/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.attributes;

import java.util.Map;
import java.util.TreeMap;

/**
 * org.astec.jdotlib.dotgraph.attributes
 * jDotlib
 * Created by alekum on 02.08.15 23:25.
 */

public class Attributes
{
    final private Map<String,Attribute> attributes;

    public Attributes()
    {
        this.attributes = new TreeMap<>();
    }

    public void addAttribute(String attrName, Attribute attr)
    {

        if( !this.attributes.containsKey( attrName ) )
            this.attributes.put( attrName , attr );
    }

    public Map<String, Attribute> getAttributesMap()
    {
        return this.attributes;
    }

    public Attribute getAttributeByName(String attrName)
    {
        return this.attributes.get( attrName );
    }

    public Iterable<String> getAttributesNames()
    {
        return this.attributes.keySet();
    }

    public Iterable<Attribute> getAttributesObjects()
    {
        return this.attributes.values();
    }

    public boolean isAttributesEmpty()
    {
        return this.attributes.isEmpty();
    }

    public boolean containsAttribute(String attrName)
    {
        return this.attributes.containsKey(attrName);
    }

    @Override
    public String toString()
    {
        if(this.isAttributesEmpty())
        {
            return ""; // TODO: if object is empty then  just return empty string to avoid NPE, need fix- ?
        }

        StringBuffer sb = new StringBuffer();
        sb.append("[ ");

        this.getAttributesObjects().forEach( (attr) -> sb.append(attr.toString()) );

        sb.append(" ]");
        return sb.toString();
    }
}
