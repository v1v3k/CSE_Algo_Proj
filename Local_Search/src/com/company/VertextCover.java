package com.company;

        import java.util.*;
        import java.io.*;

        import com.sun.org.apache.xpath.internal.operations.Bool;
        import org.jgraph.graph.DefaultEdge;
        import org.jgrapht.UndirectedGraph;
        import org.jgrapht.graph.SimpleGraph;
        import org.jgrapht.alg.VertexCovers;


/**
 * Created by george on 11/12/15.
 */
public class VertextCover {

    public  static void main(String args[]){

        UndirectedGraph<Vertex, DefaultEdge> g = new SimpleGraph<Vertex, DefaultEdge>(DefaultEdge.class);




    }
}

class Vertex{

    int id;
    String name;
    Boolean visited;

    Vertex(int id, String name, Boolean visited)
    {
        this.id = id;
        this.name = name;
        this.visited =visited;
    }

    int getId()
    {
        return this.id;
    }

    Boolean getVisited()
    {
        return this.visited;
    }

    String getName(){
        return this.name;
    }

    void setId(int id)
    {
        this.id = id;
    }
    void setName(String name)
    {
        this.name = name;
    }
    void setVisited(Boolean visited)
    {
        this.visited =visited;
    }


}
