/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */


package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attribute;
import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assert_;
import static org.junit.Assert.*;

/**
 * Node Tester.
 *
 * @author alekum
 * @version 1.0
 * @since <pre>Nov 11, 2015</pre>
 */
public class NodeTest
{

    public Node node;

    @Before
    public void before() throws Exception
    {
        Attributes attrs = new Attributes();
        attrs.addAttribute("color", new Attribute("color", "black"));

        node = new Node("op1", attrs);
    }
    
    @After
    public void after() throws Exception
    {
        node = null;
    }

    /**
     * Method: getNodeId()
     */
    @Test
    public void testGetNodeId() throws Exception
    {
        assertEquals("op1", node.getNodeId());
    }

    /**
     * Method: setNodeId(String id)
     */
    @Test
    public void testSetNodeId() throws Exception
    {
        node.setNodeId("op1_1");
        assertNotEquals("op1", node.getNodeId());
        assertEquals("op1_1", node.getNodeId());
    }

    /**
     * Method: addAttribute(Attribute attr)
     */
    @Test
    public void testAddAttribute() throws Exception
    {
        Attributes attrs = node.getAttributes();
        attrs.addAttribute("label", new Attribute("label", "andrey"));

        assertTrue(node.getAttributes().containsAttribute("label"));
        assertEquals("andrey", node.getAttributes().getAttributeByName("label").getAttributeValue());

        Attribute attr = new Attribute("style", "filled");
        node.addAttribute(attr);

        assertNotNull(node.getAttributes());
        assertTrue(node.getAttributes().containsAttribute("style"));
    }

    /**
     * Method: setAttributes(Attributes attrs)
     */
    @Test
    public void testSetAttributes() throws Exception
    {
        Attributes attrs = new Attributes();
        attrs.addAttribute("color", new Attribute("color", "yellow"));

        node.setAttributes(attrs);

        assertSame(attrs, node.getAttributes());
    }

    /**
     * Method: getAttributes()
     */
    @Test
    public void testGetAttributes() throws Exception
    {
        // TODO : node get attributes test is a dirty hack
        assertNotNull(node.getAttributes());
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception
    {
        assertEquals("op1[ color=\"black\"; ];", node.toString());

        node.setAttributes(new Attributes());
        assertEquals("op1;", node.toString());
    }

    /**
     * Method: default constructor with null attrs
     */
    @Test
    public void testNodeWithoutAttributes() throws Exception
    {
        Node node1 = new Node("op2");
        Attributes attrs = new Attributes();

        attrs.addAttribute("color", new Attribute("color", "black"));

        assertNotNull(node1.getAttributes());
        assertTrue(node1.getAttributes().isAttributesEmpty());
    }

    /**
     * Method: compareTo(Node node)
     */
    @Test
    public void testCompareTo() throws Exception
    {
        Node node0 = new Node("op1");
        Node node1 = new Node("op2");
        Node node2 = new Node("op1");

        assert_().that(node0.compareTo(node1)).isEqualTo(-1);
        assert_().that(node1.compareTo(node2)).isNotEqualTo(0);
        assert_().that(node2.compareTo(node0)).isEqualTo(0);
        assert_().that(node0.compareTo(node2)).isEqualTo(0);
        assert_().that(node.compareTo(node1)).isNotEqualTo(0);
        assert_().that(node.compareTo(node0)).isEqualTo(0);
        assert_().that(node.compareTo(node2)).isEqualTo(0);
        assert_().that(node0.compareTo(node)).isEqualTo(0);
        assert_().that(node2.compareTo(node)).isEqualTo(0);
        assert_().that(node1.compareTo(node)).isNotEqualTo(0);
    }

    /**
     * Method: compareTo(Node node)
     */
    @Test
    public void testEquals() throws Exception
    {
        Node node1 = new Node("op1");
        Node node2 = new Node("op2");
        Node node3 = new Node("OP1");

        assert_().that(node.equals(node1)).isTrue();
        assert_().that(node.equals(node2)).isFalse();
        assert_().that(node1.equals(node2)).isFalse();
        assert_().that(node.equals(node)).isTrue();
        assert_().that(node.equals(node3)).isTrue();
    }
}
