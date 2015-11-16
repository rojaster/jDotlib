/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.api.IGraph;
import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.astec.jdotlib.dotgraph.attributes.types.GraphType;

import java.util.Set;
import java.util.TreeSet;

/**
 * org.astec.jdotlib.dotgraph
 * jDotlib
 * Created by alekum on 03.08.15 22:09.
 */

final public class Graph<T extends Node, E extends Edge<T>> implements IGraph<T, E>
{
    private GraphType gType;
    private Set<T> nodes;
    private Set<E> edges;
    private Set<Graph> subgraphs;
    private Attributes attributes;


    public Graph(GraphType gtype)
    {
        this(new TreeSet<T>(),
             new TreeSet<E>(),
             new TreeSet<Graph>(),
             new Attributes(),
             gtype);
    }

    public Graph()
    {
        this(new TreeSet<T>(),
             new TreeSet<E>(),
             new TreeSet<Graph>(),
             new Attributes(),
             GraphType.DIGRAPH);
    }

    public Graph(Set<T> nodes, Set<E> edges)
    {
        this(nodes,
             edges,
             new TreeSet<>(),
             new Attributes(),
             GraphType.DIGRAPH);
    }

    public Graph(Set<T> nodes,
                 Set<E> edges,
                 Set<Graph> subgraphs)
    {
        this(nodes, edges, subgraphs, new Attributes(), GraphType.DIGRAPH);
    }

    public Graph(Set<T> nodes,
                 Set<E> edges,
                 Set<Graph> subgraphs,
                 Attributes attrs,
                 GraphType graphType)
    {
        this.nodes = nodes;
        this.edges = edges;
        this.subgraphs = subgraphs;
        this.attributes = attrs;
        this.gType = graphType;
    }

    @Override
    public void addNode(T node)
    {
        this.nodes.add(node);
    }

    @Override
    public void addEdge(Edge<T> edge)
    {
        this.edges.add((E) edge);
    }

    @Override
    public Iterable<T> getGraphNodes()
    {
        return this.nodes;
    }

    @Override
    public Iterable<E> getGraphEdges()
    {
        return this.edges;
    }

    public void addEdge(T start, T finished)
    {
        this.addEdge(new Edge<T>(start, finished));
    }

    public GraphType getGraphType()
    {
        return this.gType;
    }

    public void setGraphType(GraphType type)
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
