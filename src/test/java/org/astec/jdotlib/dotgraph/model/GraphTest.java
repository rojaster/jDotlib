/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attribute;
import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.astec.jdotlib.dotgraph.attributes.types.Colors;
import org.astec.jdotlib.dotgraph.attributes.types.GraphType;
import org.astec.jdotlib.dotgraph.attributes.types.Shapes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assert_;

/**
 * Graph Tester.
 *
 * @author alekum
 * @version 1.0
 * @since <pre>Dec 7, 2015</pre>
 */
public class GraphTest
{

    Graph<Node, Edge<Node>> graph;

    @Before
    public void before() throws Exception
    {
        graph = new Graph<>("graph1");
    }
    
    @After
    public void after() throws Exception
    {
    }

    /**
     * Method: addNode(T node)
     */
    @Test
    public void testAddNode() throws Exception
    {
        Node node1 = new Node("op1");
        Node node2 = new Node("op2");
        Node node3 = new Node("op3");

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        assert_().that(graph.getGraphNodes()).hasSize(3);

        Node tmp_node = node1;
        graph.addNode(tmp_node);

        assert_().that(graph.getGraphNodes()).isNotEmpty();
        assert_().that(graph.getGraphNodes()).hasSize(3);
        assert_().that(graph.getGraphNodes()).containsAllOf(node1, node2, node3);

        Node node_bad = new Node("op1");

        Attributes attrs = new Attributes();
        attrs.addAttribute("shape", new Attribute("shape", Shapes.BOX));
        Node node_bad1 = new Node("op1", attrs);

        graph.addNode(node_bad);
        graph.addNode(node_bad1);

        assert_().that(graph.getGraphNodes()).hasSize(3);
        assert_().that(graph.getGraphNodes()).containsNoDuplicates();
        assert_().that(graph.getGraphNodes()).isNoneOf(node_bad, node_bad1);
    }

    /**
     * Method: addEdge(Edge<T> edge)
     */
    @Test
    public void testAddEdgeEdge() throws Exception
    {
        Node n = new Node("op1");
        Node n1 = new Node("op2");
        Node n2 = new Node("op3");

        Edge<Node> edge = new Edge<>(n, n1);
        Edge<Node> edge1 = new Edge<>(n1, n2);
        Edge<Node> edge2 = new Edge<>(n2, n1);
        Edge<Node> edge3 = new Edge<>(n, n2);

        graph.addEdge(edge);
        graph.addEdge(edge1);
        graph.addEdge(edge2);

        assert_().that(graph.getGraphEdges()).isNotEmpty();
        assert_().that(graph.getGraphEdges()).hasSize(3);
        assert_().that(graph.getGraphEdges()).containsExactly(edge, edge1, edge2);
        assert_().that(graph.getGraphEdges()).doesNotContain(edge3);
    }

    /**
     * Method: addEdge(T start, T finished)
     */
    @Test
    public void testAddEdgeForStartFinished() throws Exception
    {
        Node n = new Node("1");
        Node n1 = new Node("2");

        graph.addEdge(n, n1);

        assert_().that(graph.getGraphEdges()).isNotEmpty();
        assert_().that(graph.getGraphEdges()).hasSize(1);

        graph.getGraphEdges().forEach( e -> {
            assert_().that(e.getStartNode()).isSameAs(n);
            assert_().that(e.getFinishedNode()).isSameAs(n1);
        });
    }

    /**
     * Method: getGraphType()
     */
    @Test
    public void testGetGraphType() throws Exception
    {
        assert_().that(graph.getGraphType()).isEqualTo(GraphType.DIGRAPH);
        assert_().that(graph.getGraphType()).isNotEqualTo(GraphType.GRAPH);
    }

    /**
     * Method: setGraphType(GraphType type)
     */
    @Test
    public void testSetGraphType() throws Exception
    {
        graph.setGraphType(GraphType.GRAPH);
        assert_().that(graph.getGraphType()).isNotEqualTo(GraphType.DIGRAPH);
        assert_().that(graph.getGraphType()).isEqualTo(GraphType.GRAPH);
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception
    {
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

        assert_().that(graph.toString()).isNotEmpty();
        assert_().that(graph.toString()).contains(expectedResult);
        assert_().that(graph.toString()).startsWith("digraph");
        assert_().that(graph.toString()).doesNotContain("b3");
    }
} 
