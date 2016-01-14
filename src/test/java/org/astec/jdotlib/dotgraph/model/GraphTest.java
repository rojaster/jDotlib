package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attribute;
import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.astec.jdotlib.dotgraph.attributes.types.Colors;
import org.astec.jdotlib.dotgraph.attributes.types.Shapes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assert_;
import static org.astec.jdotlib.dotgraph.attributes.types.GraphType.DIGRAPH;

/** 
* Graph Tester.
* 
* @author alekum 
* @since <pre>Jan 11, 2016</pre> 
* @version 1.0 
*/ 
public class GraphTest
{ 

    IGraph<Node, Edge<Node>> graph;

    @Before
    public void before() throws Exception 
    {
        graph = new Graph<>("graphTest");

        Node node1 = new Node("op1");
        Node node2 = new Node("op2");
        Node node3 = new Node("op3");

        Edge<Node> edge = new Edge<>(node1, node2);
        Edge<Node> edge1 = new Edge<>(node1, node3);
        Edge<Node> edge2 = new Edge<>(node2, node3);

        graph.addEdge(edge);
        graph.addEdge(edge1);
        graph.addEdge(edge2);
    } 
    
    @After
    public void after() throws Exception 
    {
        graph = null;
    } 
    
    /**
    * 
    * Method: getLabel() 
    * 
    */ 
    @Test
    public void testGetLabel() throws Exception 
    { 
        assert_().that("graphTest").isEqualTo(graph.getLabel());
    } 

    /**
    * 
    * Method: addNode(T node) 
    * 
    */ 
    @Test
    public void testAddNode() throws Exception 
    { 
        Node node = new Node("op4");

        graph.addNode(node);

        assert_().that(node).isIn(graph.getAllNodes());
    } 

    /**
    * 
    * Method: addNodes(Iterable<T> nodesList) 
    * 
    */ 
    @Test
    public void testAddNodes() throws Exception 
    {
        List<Node> nodes = new ArrayList<>();
        Node node4 = new Node("op4");
        Node node5 = new Node("op5");

        nodes.add(node4);
        nodes.add(node5);

        graph.addNodes(nodes);

        assert_().that(nodes).containsAnyIn(graph.getAllNodes());
    } 

    /**
    * 
    * Method: addEdge(E edge) 
    * 
    */ 
    @Test
    public void testAddEdgeEdge() throws Exception 
    {
        Node n = new Node("op11");
        Node n1 = new Node("op12");
        Node n2 = new Node("op13");

        Edge<Node> edge = new Edge<>(n, n1);
        Edge<Node> edge1 = new Edge<>(n1, n2);
        Edge<Node> edge2 = new Edge<>(n2, n1);
        Edge<Node> edge3 = new Edge<>(n, n2);

        graph.addEdge(edge);
        graph.addEdge(edge1);
        graph.addEdge(edge2);

        assert_().that(graph.getAllEdges()).doesNotContain(edge3);
        assert_().that(graph.containsEdge(edge)).isTrue();
        assert_().that(graph.containsEdge(edge2)).isTrue();
        assert_().that(graph.containsEdge(edge3)).isFalse();
    } 

    /**
    * 
    * Method: addEdge(T source, T target) 
    * 
    */ 
    @Test
    public void testAddEdgeForSourceTarget() throws Exception 
    {
        Node n = new Node("1");
        Node n1 = new Node("2");

        graph.addEdge(n, n1);

        assert_().that(graph.containsEdge(n, n1)).isTrue();
    } 

    /**
    * 
    * Method: getEdge(T source, T target) 
    * 
    */ 
    @Test
    public void testGetEdge() throws Exception 
    { 
        Edge<Node> edge = graph.getEdge(new Node("op1"), new Node("op2"));

        assert_().that(edge).isNotNull();
        assert_().that(graph.containsEdge(edge)).isTrue();
    } 

    /**
    * 
    * Method: getAllNodes() 
    * 
    */ 
    @Test
    public void testGetAllNodes() throws Exception 
    {
        Node n = new Node("op11");
        Node n1 = new Node("op12");
        Iterable<Node> nodes = graph.getAllNodes();

        assert_().that(nodes).containsNoneOf(n, n1);

        graph.addNode(n);
        graph.addNode(n1);

        assert_().that(nodes).containsAllOf(n, n1);
        assert_().that(graph.getAllNodes()).hasSize(5);
    } 

    /**
    * 
    * Method: getAllEdges() 
    * 
    */ 
    @Test
    public void testGetAllEdges() throws Exception 
    { 
        assert_().that(graph.getAllEdges()).isNotEmpty();
        assert_().that(graph.getAllEdges()).hasSize(3);
    }

    /**
    * 
    * Method: getAllSubGraphs() 
    * 
    */ 
    @Test
    public void testGetAllSubGraphs() throws Exception 
    { 
        assert_().that(graph.getAllSubGraphs()).isEmpty();
    } 

    /**
    * 
    * Method: getAttributes() 
    * 
    */ 
    @Test
    public void testGetAttributes() throws Exception 
    { 
        assert_().that(graph.getAttributes()).isNotNull();
    } 

    /**
    * 
    * Method: setAttributes(Attributes attrs) 
    * 
    */ 
    @Test
    public void testSetAttributes() throws Exception 
    { 
        //TODO : pass, because broken
    } 

    /**
    * 
    * Method: containsNode(T node) 
    * 
    */ 
    @Test
    public void testContainsNode() throws Exception 
    { 
        assert_().that(graph.containsNode(new Node("op1"))).isTrue();
        assert_().that(graph.containsNode(new Node("op11"))).isFalse();
    } 

    /**
    * 
    * Method: containsNode(String nodeLabel)
    *
    */
    @Test
    public void testContainsNodeNodeLabel() throws Exception
    {
        assert_().that(graph.containsNode("op1")).isTrue();
        assert_().that(graph.containsNode("op11")).isFalse();
    }

    /**
    *
    * Method: containsEdge(E edge)
    * 
    */ 
    @Test
    public void testContainsEdgeEdge() throws Exception 
    { 
        Node op11 = new Node("op11");
        Node op12 = new Node("op12");
        Edge<Node> edge = new Edge<>(op11, op12);
        Edge<Node> edge1 = new Edge<>(op12, op11);

        graph.addEdge(edge);

        assert_().that(graph.containsEdge(edge)).isTrue();
        assert_().that(graph.containsEdge(edge1)).isFalse();
    }

    /**
     *
     * Method: containsEdge(String nodeSourceLabel, String nodeTargetLabel)
     *
     */
    @Test
    public void testContainsEdgeForNodeSourceLabelNodeTargetLabel() throws Exception
    {
        assert_().that(graph.containsEdge("op1", "op2")).isTrue();
        assert_().that(graph.containsEdge("op3", "op2")).isFalse();
    }

    /**
    * 
    * Method: containsEdge(T source, T target) 
    * 
    */ 
    @Test
    public void testContainsEdgeForSourceTarget() throws Exception 
    {
        assert_().that(graph.containsEdge(new Node("op1"), new Node("op2"))).isTrue();
        assert_().that(graph.containsEdge(new Node("op3"), new Node("op2"))).isFalse();
    } 

    /**
    * 
    * Method: removeNode(T node) 
    * 
    */ 
    @Test
    public void testRemoveNode() throws Exception 
    { 
        assert_().that(graph.containsNode("op1")).isTrue();

        graph.removeNode(new Node("op1"));

        assert_().that(graph.containsNode("op1")).isFalse();
    }

    /**
    * 
    * Method: removeEdge(E edge) 
    * 
    */ 
    @Test
    public void testRemoveEdgeEdge() throws Exception 
    {
        Node op11 = new Node("op11");
        Node op12 = new Node("op12");
        Edge<Node> edge = new Edge<>(op11, op12);
        graph.addEdge(edge);

        assert_().that(graph.containsEdge(edge)).isTrue();

        graph.removeEdge(edge);

        assert_().that(graph.containsEdge("op11", "op12")).isFalse();
    } 

    /**
    * 
    * Method: removeEdge(T source, T target) 
    * 
    */ 
    @Test
    public void testRemoveEdgeForSourceTarget() throws Exception 
    { 
        Node n = new Node("op1");
        Node n1 = new Node("op2");

        assert_().that(graph.containsEdge(n, n1)).isTrue();

        graph.removeEdge(n, n1);

        assert_().that(graph.containsEdge(n, n1)).isFalse();
    } 

    /**
    * 
    * Method: removeAllEdges(Collection<E> edges) 
    * 
    */ 
    @Test
    public void testRemoveAllEdges() throws Exception 
    {
        assert_().that(graph.getAllEdges()).isNotEmpty();

        graph.removeAllEdges();

        assert_().that(graph.getAllEdges()).isEmpty();
    } 

    /**
    * 
    * Method: removeAllNodes(Collection<T> nodes) 
    * 
    */ 
    @Test
    public void testRemoveAllNodes() throws Exception 
    {
        assert_().that(graph.getAllNodes()).isNotEmpty();

        graph.removeAllNodes();

        assert_().that(graph.getAllNodes()).isEmpty();
    } 

    /**
    * 
    * Method: getDot() 
    * 
    */ 
    @Test
    public void testGetDot() throws Exception 
    {
        graph.removeAllNodes();

        Attributes attrsNodes = new Attributes();
        Attribute attrNodeColor = new Attribute("color", Colors.BLACK);
        Attribute attrNodeShape = new Attribute("shape", Shapes.OCTAGON);

        attrsNodes.addAttribute("color", attrNodeColor);
        attrsNodes.addAttribute("shape", attrNodeShape);


        Node node0 = new Node("a0", attrsNodes);
        Node node1 = new Node("a1");
        Node node2 = new Node("a2", attrsNodes);
        Node node3 = new Node("a3");

        Attributes attrsEdges = new Attributes();
        Attribute attrEdge = new Attribute("color", Colors.GREEN);

        attrsEdges.addAttribute("color", attrEdge);

        Edge<Node> edge = new Edge<>(node2, node3, attrsEdges);

        graph.addEdge(node0, node1);
        graph.addEdge(node1, node2);
        graph.addEdge(edge);


        String expectedResult = "digraph { a0[ color=\"black\";shape=\"octagon\"; ];" +
                "a1;a2[ color=\"black\";shape=\"octagon\"; ];"       +
                "a3;a0 -> a1;a1 -> a2;a2 -> a3[ color=\"green\"; ]; }";

        assert_().that(graph.getDot()).isNotEmpty();
        assert_().that(graph.getDot()).contains(expectedResult);
        assert_().that(graph.getDot()).startsWith("digraph");
        assert_().that(graph.getDot()).doesNotContain("b3");
    } 

    /**
    * 
    * Method: getType() 
    * 
    */ 
    @Test
    public void testGetType() throws Exception 
    { 
        assert_().that(graph.getType()).isEqualTo(DIGRAPH);
    } 


    /**
    *
    * Method: equals(Object obj)
    * 
    */ 
    @Test
    public void testEquals() throws Exception 
    {
        IGraph<Node, Edge<Node>> testEqGraph = new Graph<>(graph.getLabel());
        IGraph<Node, Edge<Node>> testNeqGraph = new Graph<>("graphNotEqual");

        assert_().that(graph).isEqualTo(testEqGraph);
        assert_().that(graph).isNotEqualTo(testNeqGraph);
        assert_().that(graph).isEqualTo(graph);
    }
} 
