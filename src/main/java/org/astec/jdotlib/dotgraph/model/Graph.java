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
    private String label;
    private GraphType gType;
    private Set<T> nodes;
    private List<E> edges;
    private List<Graph> subgraphs;
    private Attributes attributes;

    public Graph(String label)
    {
        this(label, GraphType.DIGRAPH);
    }

    public Graph(String label, GraphType gtype)
    {
        this(label,
             new TreeSet<T>(),
             new ArrayList<E>(),
             new ArrayList<Graph>(),
             new Attributes(),
             gtype);
    }


    public Graph(String l,
                 Set<T> nodes,
                 List<E> edges,
                 List<Graph> subgraphs,
                 Attributes attrs,
                 GraphType graphType)
    {
        if(l.isEmpty() || graphType == null)
            throw new IllegalArgumentException("Label and Type of Graph must not be null or empty");

        this.label = l;
        this.nodes = nodes;
        this.edges = edges;
        this.subgraphs = subgraphs;
        this.attributes = attrs;
        this.gType = graphType;
    }

    public String getGraphLabel()
    {
        return this.label;
    }

    public void addNode(T node)
    {
        if(node == null)
            throw new IllegalArgumentException("Node must no be null");

        this.nodes.add(node);
    }

    /*
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this set
     */
    @SuppressWarnings("unchecked")
    public void addEdge(Edge<T> edge)
    {
        if(edge == null)
            throw new IllegalArgumentException("Edge must not be null");

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
        if(start == null || finished == null)
            throw new IllegalArgumentException("Node must not be null");

        this.addEdge(new Edge<T>(start, finished));
    }

    public GraphType getGraphType()
    {
        return this.gType;
    }

    public void setGraphType(GraphType type)
    {
        if(type == null)
            throw new IllegalArgumentException("Type of Graph must not be null");

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
        sb.append( this.gType == GraphType.DIGRAPH ? "digraph" : "graph"  + this.label);
        sb.append(" { ");

        this.nodes.forEach(n->sb.append(n.toString()));
        this.edges.forEach(e->sb.append(e.toString()));
        sb.append(this.attributes.toString());

        sb.append(" } ");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj )
    {
        if(super.equals(obj))
            return true;

        if(!(obj instanceof Graph))
            return false;

        return this.label.equals( ((Graph) obj).getGraphLabel() );
    }
}
