package org.astec.jdotlib.dotgraph.attributes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/** 
* Attributes Tester. 
* 
* @author alekum 
* @since <pre>Aug 3, 2015</pre> 
* @version 1.0 
*/ 
public class AttributesTest 
{
    Attributes attributes;

    @Before
    public void before() throws Exception 
    {
        attributes = new Attributes();

        attributes.addAttribute( "color", new Attribute("color","black") );
        attributes.addAttribute( "style", new Attribute("style","filled"));
        attributes.addAttribute( "xlabel", new Attribute("xlabel","textsomehere"));
    } 
    
    @After
    public void after() throws Exception 
    {
        attributes = null;
    } 
    
    /**
    * 
    * Method: addAttribute(String attrName, Attribute attr) 
    * 
    */ 
    @Test
    public void testAddAttribute() throws Exception 
    {
        attributes.addAttribute("color", new Attribute("color", "black"));
        assertTrue(attributes.containsAttribute("color"));
        assertTrue(attributes.getAttributeByName("color").getAttributeValue().equals("black"));
    } 

    /**
    * 
    * Method: getAttributesMap() 
    * 
    */ 
    @Test
    public void testGetAttributesMap() throws Exception 
    {
        assertTrue(attributes.getAttributesMap() instanceof Map);
    } 

    /**
    * 
    * Method: getAttributeByName(String attrName) 
    * 
    */ 
    @Test
    public void testGetAttributeByName() throws Exception 
    { 
        assertTrue(attributes.getAttributeByName("color").getAttributeName().equals("color"));
    } 

    /**
    * 
    * Method: getAttributesNames() 
    * 
    */ 
    @Test
    public void testGetAttributesNames() throws Exception 
    {
        for(String key : attributes.getAttributesNames())
            assertTrue(key.equals("color") || key.equals("style") || key.equals("xlabel"));
    } 

    /**
    * 
    * Method: getAttributesObjects() 
    * 
    */ 
    @Test
    public void testGetAttributesObjects() throws Exception 
    { 
        assertTrue(attributes.getAttributesObjects() instanceof Iterable);
    } 

    /**
    * 
    * Method: isAttributesEmpty() 
    * 
    */ 
    @Test
    public void testIsAttributesEmpty() throws Exception 
    { 
        assertFalse( attributes.isAttributesEmpty() );
    } 

    /**
    * 
    * Method: containsAttribute(String attrName) 
    * 
    */ 
    @Test
    public void testContainsAttribute() throws Exception 
    { 
        assertTrue(attributes.containsAttribute("style"));
    } 

    /**
    * 
    * Method: toString() 
    * 
    */ 
    @Test
    public void testToString() throws Exception
    {
        assertEquals("[ color=\"black\";style=\"filled\";xlabel=\"textsomehere\"; ]", attributes.toString());

        attributes = attributes.isAttributesEmpty() ? attributes : new Attributes();

        assertNotEquals("[  ]", attributes.toString());
        assertEquals("", attributes.toString());
    }
}
