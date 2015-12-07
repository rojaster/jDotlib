package org.astec.jdotlib.dotgraph.attributes;

import org.astec.jdotlib.dotgraph.attributes.types.Colors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assert_;
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

    /**
     * Method: compareTo(Attribute o)
     */
    @Test
    public void testCompareTo() throws Exception
    {
        Attribute attr0 = new Attribute("color", Colors.AQUA);
        Attribute attr1 = new Attribute("color", Colors.CYAN);
        Attribute attr2 = new Attribute("color", Colors.AQUA);

        assert_().that(attr0).isEquivalentAccordingToCompareTo(attr2);
        assert_().that(attr1).isNotSameAs(attr2);
        assert_().that(attr0).isSameAs(attr0);
        assert_().that(attr2).isNotEqualTo(attr1);

        assert_().that(attr0.compareTo(attr2)).isEqualTo(0);
        assert_().that(attr1.compareTo(attr0)).isEqualTo(-1);

        assert_().that(attr0.compareTo(attr0)).isEqualTo(0);
    }
} 
