/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.attributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * org.astec.jdotlib.dotgraph.attributes
 * jDotlib
 * Created by alekum on 02.08.15 23:25.
 */

public class Attributes implements Comparable<Attributes>
{
    final private Map<String,Attribute> attributes;

    public Attributes()
    {
        this.attributes = new HashMap<>();
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
            // TODO: if object is empty then  just return empty string to avoid NPE, need fix- ?
            return "";
        }

        StringBuffer sb = new StringBuffer();
        sb.append("[ ");

        this.getAttributesObjects().forEach( (attr) -> sb.append(attr.toString()) );

        sb.append(" ]");
        return sb.toString();
    }

    @Override
    public int compareTo(Attributes o)
    {
        if(this == o)
            return 0;

        Set<String> key1 = this.attributes.keySet();
        Set<String> key2 = o.getAttributesMap().keySet();

        if(key1.equals(key2))
            return 0;

        return -1;
    }
}
