package com.company;

import java.util.*;
import java.io.*;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.VertexCovers;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");

        /*UndirectedGraph<Integer, DefaultEdge> g = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);

        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1,2);
        g.addEdge(2,1);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);


        g.addEdge(2,3);
        g.addEdge(2,4);

        System.out.println(g.degreeOf(2));

        System.out.println(g.toString());

        System.out.println(g.containsEdge(1,3));
        System.out.println(g.containsEdge(1,2));
        System.out.println(g.containsEdge(2,1));

        System.out.println(g.edgesOf(1).toString());
        System.out.println(g.containsVertex(1));
        System.out.println(g.vertexSet());
        System.out.println(g.edgeSet());
        /*
        g.edgeSet();
        g.edgesOf(2);
        g.containsEdge(1,2);
        g.addEdge(1,2);
        g.toString();

        g.containsEdge(1,2);
        g.getAllEdges(1,2);
        g.removeAllEdges(1,2);
//        g.removeAllVertices();
        g.vertexSet();


        DefaultEdge e = g.getEdge(1,2);
     */


        UndirectedGraph g = new SimpleGraph(DefaultEdge.class);
        g.addVertex("1");
        g.addVertex("2");
        g.addVertex("3");
        g.addVertex("4");
        g.addEdge("1", "3");
        g.addEdge("1", "4");
        g.addEdge("1", "4");
        g.addEdge("1", "4");
        g.addEdge("1", "3");
        g.addEdge("1", "4");

        Set vertices = g.vertexSet();
        Set covers = VertexCovers.findGreedyCover(g);
        System.out.println(covers);

        Object[] vertexSet = g.vertexSet().toArray();
        Object[] edgeSet = g.edgesOf("1").toArray();

        for (Object o: vertexSet){
            System.out.println((o).toString());
        }

        /*for(DefaultEdge e: g.edgesOf("1")){
            String v = g.getEdgeTarget(e);
*/
    }
}
