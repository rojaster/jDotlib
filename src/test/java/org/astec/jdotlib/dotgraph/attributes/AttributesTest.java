package org.astec.jdotlib.dotgraph.attributes;

import org.astec.jdotlib.dotgraph.attributes.types.Colors;
import org.astec.jdotlib.dotgraph.attributes.types.Shapes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Attributes Tester.
 *
 * @author alekum
 * @version 1.0
 * @since <pre>Aug 3, 2015</pre>
 */
public class AttributesTest
{
    Attributes attributes;

    @Before
    public void before() throws Exception
    {
        attributes = new Attributes();

        attributes.addAttribute("color", new Attribute("color", "black"));
        attributes.addAttribute("style", new Attribute("style", "filled"));
        attributes.addAttribute("xlabel", new Attribute("xlabel", "textsomehere"));
    }
    
    @After
    public void after() throws Exception
    {
        attributes = null;
    }
    
    /**
     * Method: addAttribute(String attrName, Attribute attr)
     */
    @Test
    public void testAddAttribute() throws Exception
    {
        attributes.addAttribute("color", new Attribute("color", "black"));
        assertTrue(attributes.containsAttribute("color"));
        assertTrue(attributes.getAttributeByName("color").getAttributeValue().equals("black"));
    }

    /**
     * Method: getAttributesMap()
     */
    @Test
    public void testGetAttributesMap() throws Exception
    {
        assertTrue(attributes.getAttributesMap() instanceof Map);
    }

    /**
     * Method: getAttributeByName(String attrName)
     */
    @Test
    public void testGetAttributeByName() throws Exception
    {
        assertTrue(attributes.getAttributeByName("color").getAttributeName().equals("color"));
    }

    /**
     * Method: getAttributesNames()
     */
    @Test
    public void testGetAttributesNames() throws Exception
    {
        for(String key : attributes.getAttributesNames())
            assertTrue(key.equals("color") || key.equals("style") || key.equals("xlabel"));
    }

    /**
     * Method: getAttributesObjects()
     */
    @Test
    public void testGetAttributesObjects() throws Exception
    {
        assertTrue(attributes.getAttributesObjects() instanceof Iterable);
    }

    /**
     * Method: isAttributesEmpty()
     */
    @Test
    public void testIsAttributesEmpty() throws Exception
    {
        assertFalse(attributes.isAttributesEmpty());
    }

    /**
     * Method: containsAttribute(String attrName)
     */
    @Test
    public void testContainsAttribute() throws Exception
    {
        assertTrue(attributes.containsAttribute("style"));
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception
    {
        assertEquals("[ color=\"black\";style=\"filled\";xlabel=\"textsomehere\"; ]", attributes.toString());

        attributes = attributes.isAttributesEmpty() ? attributes : new Attributes();

        assertNotEquals("[  ]", attributes.toString());
        assertEquals("", attributes.toString());
    }

    /**
     * Method: compareTo(Attributes o)
     */
    @Test
    public void testCompareTo() throws Exception
    {
        Attributes attrs0 = new Attributes();
        Attributes attrs1 = new Attributes();

        Attribute attrColor = new Attribute("color", Colors.BLACK);
        Attribute attrColor1 = new Attribute("color", Colors.BLACK);

        attrs0.addAttribute("color", attrColor);
        attrs1.addAttribute("color", attrColor1);

        assertEquals(0, attrs0.compareTo(attrs1));

        Attribute attrShape = new Attribute("shape", Shapes.EGG);
        attrs1.addAttribute("shape", attrShape);

        assertNotEquals(0, attrs0.compareTo(attrs1));
    }
}
