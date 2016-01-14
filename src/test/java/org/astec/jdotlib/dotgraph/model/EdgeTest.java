/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** 
* Edge Tester. 
* 
* @author alekum 
* @since <pre>Nov 13, 2015</pre> 
* @version 1.0 
*/ 
public class EdgeTest 
{ 
    Edge<Node> edge;

    @Before
    public void before() throws Exception 
    {
        final Node node_start = new Node("n1");
        final Node node_finish = new Node("n2");
        edge = new Edge<>(node_start, node_finish);
    } 
    
    @After
    public void after() throws Exception 
    {
        edge = null;
    } 
    
    /**
    * 
    * Method: getSource()
    * 
    */ 
    @Test
    public void testGetStartNode() throws Exception 
    { 
        assertNotNull(edge.getSource());
    } 

    /**
    * 
    * Method: getTarget()
    * 
    */ 
    @Test
    public void testGetFinishedNode() throws Exception 
    { 
        assertNotNull(edge.getTarget());
    } 

    /**
    * 
    * Method: setSource(T start)
    * 
    */ 
    @Test
    public void testSetStartNode() throws Exception 
    { 
        final Node n = new Node("n_test");

        edge.setSource(n);

        assertSame(n, edge.getSource());
    } 

    /**
    * 
    * Method: setTarget(T finished)
    * 
    */ 
    @Test
    public void testSetFinishedNode() throws Exception 
    { 
        final Node n = new Node("n_test");

        edge.setTarget(n);

        assertSame(n, edge.getTarget());
    }

    /**
    * 
    * Method: toString() 
    * 
    */ 
    @Test
    public void testToString() throws Exception 
    { 
        assertNotEquals("n1 -> n2", edge.toString());
        assertNotEquals("n1 -> n2[  ]", edge.toString());
        assertEquals("n1 -> n2;", edge.toString());
    }
} 
