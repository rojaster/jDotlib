/*
 * Copyright (c) 2016.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.model;

import org.astec.jdotlib.dotgraph.attributes.Attributes;
import org.astec.jdotlib.dotgraph.attributes.types.GraphType;

import java.util.Collection;

/**
 * org.astec.jdotlib.dotgraph.model
 * jDotlib
 * Created by alekum on 1/11/16 8:48 AM.
 */
public interface IGraph<T extends Node, E extends Edge<T>>
{
    String getLabel();

    void addNode(T node);

    void addNodes(Iterable<T> nodes);

    void addEdge(E edge);

    void addEdge(T source, T target);

    E getEdge(T source, T target);

    Iterable<T> getAllNodes();

    Iterable<E> getAllEdges();

    Iterable<IGraph> getAllSubGraphs();

    Attributes getAttributes();

    void setAttributes(Attributes attrs);

    boolean containsNode(T node);

    boolean containsNode(String nodeLabel);

    boolean containsEdge(E edge);

    boolean containsEdge(String nodeSourceLabel, String nodeTargetLabel);

    boolean containsEdge(T source, T target);

    boolean removeNode(T node);

    boolean removeEdge(E edge);

    boolean removeEdge(T source, T target);

    void removeAllEdges();

    void removeAllNodes();

    boolean removeEdges(Collection<E> edges);

    boolean removeNodes(Collection<T> nodes);

    String getDot();

    GraphType getType();
}
