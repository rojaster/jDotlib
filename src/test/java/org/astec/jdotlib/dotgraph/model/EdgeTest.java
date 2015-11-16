package org.astec.jdotlib.dotgraph.model; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertSame;
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
    * Method: getStartNode() 
    * 
    */ 
    @Test
    public void testGetStartNode() throws Exception 
    { 
        assertNotNull(edge.getStartNode());
    } 

    /**
    * 
    * Method: getFinishedNode() 
    * 
    */ 
    @Test
    public void testGetFinishedNode() throws Exception 
    { 
        assertNotNull(edge.getFinishedNode());
    } 

    /**
    * 
    * Method: setStartNode(T start) 
    * 
    */ 
    @Test
    public void testSetStartNode() throws Exception 
    { 
        final Node n = new Node("n_test");

        edge.setStartNode(n);

        assertSame(n, edge.getStartNode());
    } 

    /**
    * 
    * Method: setFinishedNode(T finished) 
    * 
    */ 
    @Test
    public void testSetFinishedNode() throws Exception 
    { 
        final Node n = new Node("n_test");

        edge.setFinishedNode(n);

        assertSame(n, edge.getFinishedNode());
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
