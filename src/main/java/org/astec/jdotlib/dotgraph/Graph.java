/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph;

import org.astec.jdotlib.dotgraph.attributes.Attributes;

import java.util.Set;
import java.util.TreeSet;

/**
 * org.astec.jdotlib.dotgraph
 * jDotlib
 * Created by alekum on 03.08.15 22:09.
 */

public class Graph
{
    private String gType;
    private Set<Node> nodes;
    private Set<Edge> edges;
    private Set<Graph> subgraphs;
    private Attributes attributes;

    public static class GraphType
    {
        final public static String DIGRAPH = "digraph"; // oriented-graph
        final public static String GRAPH = "graph";     // non-oriented graph
    }

    public Graph(String graphType)
    {
        this(
              new TreeSet<Node>()
            , new TreeSet<Edge>()
            , new TreeSet<Graph>()
            , new Attributes()
            , graphType
        );
    }

    public Graph()
    {
        this(
              new TreeSet<Node>()
            , new TreeSet<Edge>()
            , new TreeSet<Graph>()
            , new Attributes()
            , GraphType.DIGRAPH
        );
    }

    public Graph(Set<Node> nodes, Set<Edge> edges)
    {
        this(
              nodes
            , edges
            , new TreeSet<>()
            , new Attributes()
            , GraphType.DIGRAPH
        );
    }

    public Graph( Set<Node> nodes, Set<Edge> edges, Set<Graph> subgraphs)
    {
        this(
              nodes
            , edges
            , subgraphs
            , new Attributes()
            , GraphType.DIGRAPH
        );
    }

    public Graph( Set<Node> nodes, Set<Edge> edges, Set<Graph> subgraphs, Attributes attrs, String graphType )
    {
        this.nodes      = nodes;
        this.edges      = edges;
        this.subgraphs  = subgraphs;
        this.attributes = attrs;
        this.gType      = graphType;
    }

    public void addNode( Node node )
    {
        this.nodes.add( node );
    }

    public void addEdge( Edge edge )
    {
        this.edges.add( edge );
    }

    public void addEdge( Node start, Node finished )
    {
        this.addEdge( new Edge(start, finished) );
    }

    public String getGraphType()
    {
        return this.gType;
    }

    public void setGraphType(String type)
    {
        this.gType = type;
    }

    @Override
    public String toString()
    {
        // TODO : Text DOT Graph representation
        return "graph fly";
    }
}
