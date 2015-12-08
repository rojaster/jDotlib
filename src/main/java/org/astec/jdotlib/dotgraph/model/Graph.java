/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.astec.jdotlib.dotgraph.attributes.types.GraphType;

import java.util.*;

/**
 * org.astec.jdotlib.dotgraph
 * jDotlib
 * Created by alekum on 03.08.15 22:09.
 */

final public class Graph<T extends Node, E extends Edge<T>>
{
    private GraphType gType;
    private Set<T> nodes;
    private List<E> edges;
    private List<Graph> subgraphs;
    private Attributes attributes;


    public Graph(GraphType gtype)
    {
        this(new TreeSet<T>(),
             new ArrayList<E>(),
             new ArrayList<Graph>(),
             new Attributes(),
             gtype);
    }

    public Graph()
    {
        this(new TreeSet<T>(),
             new ArrayList<E>(),
             new ArrayList<Graph>(),
             new Attributes(),
             GraphType.DIGRAPH);
    }

    public Graph(Set<T> nodes,
                 List<E> edges,
                 List<Graph> subgraphs,
                 Attributes attrs,
                 GraphType graphType)
    {
        this.nodes = nodes;
        this.edges = edges;
        this.subgraphs = subgraphs;
        this.attributes = attrs;
        this.gType = graphType;
    }

    public void addNode(T node)
    {
        this.nodes.add(node);
    }

    /*
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this set
     */
    @SuppressWarnings("unchecked")
    public void addEdge(Edge<T> edge)
    {
        // TODO : possibility to unsafe cast, but all going to the f*ck
        // I'm sorry
        Edge<T> e = edge;

        this.addNode(e.getStartNode());
        this.addNode(e.getFinishedNode());

        this.edges.add((E) e);
    }

    public Iterable<T> getGraphNodes()
    {
        return this.nodes;
    }

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

    public Attributes getGraphAttributes()
    {
        return this.attributes;
    }

    public void setGraphAttributes(Attributes attrs)
    {
        this.attributes = attrs;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( this.gType == GraphType.DIGRAPH ? "digraph" : "graph" );
        sb.append(" { ");

        this.nodes.forEach(n->sb.append(n.toString()));
        this.edges.forEach(e->sb.append(e.toString()));
        sb.append(this.attributes.toString());

        sb.append(" } ");
        return sb.toString();
    }
}
