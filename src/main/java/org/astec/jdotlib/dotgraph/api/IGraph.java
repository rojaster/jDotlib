/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 */

package org.astec.jdotlib.dotgraph.api;

import org.astec.jdotlib.dotgraph.model.Edge;
import org.astec.jdotlib.dotgraph.model.Node;

/**
 * org.astec.jdotlib.dotgraph.api
 * jDotlib
 * Created by alekum on 11.11.15 17:10.
 */
public interface IGraph<T extends Node, E extends Edge<T>>
{
    void addNode(T node);
    void addEdge(Edge<T> edge);

    Iterable<T> getGraphNodes();
    Iterable<E> getGraphEdges();
}
