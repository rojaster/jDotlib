package org.astec.jdotlib.dotgraph.attributes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Attribute Tester.
 *
 * @author alekum
 * @version 1.0
 * @since <pre>Aug 3, 2015</pre>
 */
public class AttributeTest
{

    Attribute attr;

    @Before
    public void before() throws Exception
    {
        attr = new Attribute("color", "black");
    }

    @After
    public void after() throws Exception
    {
        attr = null;
    }

    /**
     * Method: getAttributeName()
     */
    @Test
    public void testGetAttributeName() throws Exception
    {
        assertEquals("color", attr.getAttributeName());
    }

    /**
     * Method: getAttributeValue()
     */
    @Test
    public void testGetAttributeValue() throws Exception
    {
        assertEquals("black", attr.getAttributeValue());
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception
    {
        assertEquals("color=\"black\";", attr.toString());
    }

} 
