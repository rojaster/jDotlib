/*
 * Copyright (c) 2016.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.astec.jdotlib.dotgraph.attributes.types.GraphType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * org.astec.jdotlib.dotgraph.model
 * jDotlib
 * Created by alekum on 1/11/16 9:18 AM.
 */

public class Graph<T extends Node, E extends Edge<T>> implements IGraph<T, E>
{
    private String label;
    private GraphType gType;
    private Set<T> nodes;
    private List<E> edges;
    private List<IGraph> subgraphs;
    private Attributes attributes;

    public Graph(String label)
    {
        this(label, GraphType.DIGRAPH);
    }

    public Graph(String label, GraphType gtype)
    {
        this(label,
             new TreeSet<>(),
             new ArrayList<>(),
             new ArrayList<>(),
             new Attributes(),
             gtype);
    }


    public Graph(String l,
                 Set<T> nodes,
                 List<E> edges,
                 List<IGraph> subgraphs,
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

    @Override
    public String getLabel()
    {
        return this.label;
    }

    @Override
    public void addNode(T node)
    {
        if(node == null)
            throw new IllegalArgumentException("Node must no be null");

        this.nodes.add(node);
    }

    @Override
    public void addNodes(Iterable<T> nodesList)
    {
        nodesList.forEach(this::addNode);
    }

    /*
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this set
     */
    @SuppressWarnings("unchecked")
    @Override
    public void addEdge(E edge)
    {
        if(edge == null)
            throw new IllegalArgumentException("Edge must not be null");

        this.addNode(edge.getSource());
        this.addNode(edge.getTarget());

        this.edges.add(edge);
    }

    /*
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this set
     */
    @SuppressWarnings("unchecked")
    @Override
    public void addEdge(T source, T target)
    {
        if(source == null || target == null)
            throw new IllegalArgumentException("Node must not be null");

        this.addEdge( (E)new Edge<>(source, target)  );
    }

    @Override
    public E getEdge(T source, T target)
    {
        if(!(this.containsNode(source) && this.containsNode(target)))
            return null;

        return this.edges.stream()
                .filter( e -> ( e.getSource().equals(source) && e.getTarget().equals(target) ) )
                .findFirst().get();
    }

    @Override
    public Iterable<T> getAllNodes()
    {
        return this.nodes;
    }

    @Override
    public Iterable<E> getAllEdges()
    {
        return this.edges;
    }

    @Override
    public Iterable<IGraph> getAllSubGraphs()
    {
        return this.subgraphs;
    }

    @Override
    public Attributes getAttributes()
    {
        return this.attributes;
    }

    @Override
    public void setAttributes(Attributes attrs)
    {
        this.attributes = attrs;
    }

    @Override
    public boolean containsNode(T node)
    {
        return this.nodes.contains(node);
    }

    @Override
    public boolean containsNode(String nodeLabel)
    {
        return this.nodes.stream().anyMatch( n -> n.getNodeId().equals(nodeLabel) );
    }

    @Override
    public boolean containsEdge(E edge)
    {
        return this.edges.contains(edge);
    }

    @Override
    public boolean containsEdge(String nodeSourceLabel, String nodeTargetLabel)
    {
        return this.edges
                .stream()
                .anyMatch( e -> e.getSource().getNodeId().equals(nodeSourceLabel)
                                && e.getTarget().getNodeId().equals(nodeTargetLabel));
    }

    @Override
    public boolean containsEdge(T source, T target)
    {
        return (this.containsNode(source) && this.containsNode(target))
                && this.edges.stream().anyMatch( e -> e.getSource().equals(source) && e.getTarget().equals(target) );

    }

    @Override
    public boolean removeNode(T node)
    {
        this.edges = this.edges.stream()
                        .filter( e -> (!(e.getSource().equals(node) || e.getTarget().equals(node))) )
                        .collect(Collectors.toList());

        return this.nodes.remove(node);
    }

    @Override
    public boolean removeEdge(E edge)
    {
        return this.edges.remove(edge);
    }

    @Override
    public boolean removeEdge(T source, T target)
    {
        return this.containsEdge(source, target) && this.edges.remove(this.getEdge(source, target));
    }

    @Override
    public void removeAllEdges()
    {
       this.edges.clear();
    }

    @Override
    public void removeAllNodes()
    {
        this.removeAllEdges();
        this.nodes.clear();
    }

    @Override
    public boolean removeEdges(Collection<E> edges)
    {
        return this.edges.removeAll(edges);
    }

    @Override
    public boolean removeNodes(Collection<T> nodes)
    {
        return this.nodes.removeAll(nodes);
    }

    @Override
    public String getDot()
    {
        return this.toString();
    }

    @Override
    public GraphType getType()
    {
        return this.gType;
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
        return super.equals(obj) || obj instanceof Graph && this.label.equals(((Graph) obj).getLabel());
    }
}
