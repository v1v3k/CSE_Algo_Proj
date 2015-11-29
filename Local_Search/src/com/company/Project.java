package com.company;

/**
 * Created by george on 11/15/15.
 */

import java.util.*;
import java.io.*;

import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.Edge;
import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.VertexCovers;
import org.jgrapht.alg.util.VertexDegreeComparator;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.UndirectedSubgraph;



public class Project {


    public static int max_cover =  0;
    public static int no_of_edges = 0;
    public static int no_of_vertex = 0;
    public static int lower_bound_g = 0;
    public static int upper_bound_g = 0;
    public static int best_sol = 0;
    public static Set<Integer> best_set =null;
    public  static ArrayList<Integer> v_sort = new ArrayList();


    public static UndirectedGraph<Integer, DefaultEdge> GraphCreate(Scanner s){
        UndirectedGraph<Integer, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
        String first = s.nextLine();
        String[] firstsplit = first.split(" ");
        no_of_vertex = Integer.parseInt(firstsplit[0]);
        no_of_edges = Integer.parseInt(firstsplit[1]);
        int directed = Integer.parseInt(firstsplit[2]);
        int vertex_num=1;
        while (s.hasNextLine()) {
            g.addVertex(vertex_num);
            String curLine = s.nextLine();

            if (!curLine.equals("")){
            String[] cursplit = curLine.split(" ");
            for (int j=0; j < cursplit.length; j++) {
                int out_vertex =Integer.parseInt(cursplit[j]);
                g.addVertex(out_vertex);
                g.addEdge(vertex_num, out_vertex);
            }}
            vertex_num++;
        }
        return  g;
    }


    public static int MaximumCover(SimpleGraph g1){
        SimpleGraph g = (SimpleGraph) g1.clone();
        VertexDegreeComparator comp = new VertexDegreeComparator(g);

        int count =0;
        while(g.edgeSet().size() > 0) {
            Object v = Collections.max(g.vertexSet(), comp);
            Object k = Graphs.neighborListOf(g,v);
            Object v1 = ((ArrayList)(k)).get(0);
            g.removeVertex(v);
            g.removeVertex(v1);
            count++;
        }
        return count;
    }


    public static int UpperBound(SimpleGraph g1){
        SimpleGraph g = (SimpleGraph) g1.clone();
        VertexDegreeComparator comp = new VertexDegreeComparator(g);
        int count =0;
        while(g.edgeSet().size() > 0) {
            Object v = Collections.max(g.vertexSet(), comp);
            g.removeVertex(v);
            count++;
        }
        return count;
    }


    public static void sort_v(SimpleGraph g1){
        SimpleGraph g = (SimpleGraph) g1.clone();
        VertexDegreeComparator comp = new VertexDegreeComparator(g);
        int v_size = g.vertexSet().size();
        v_sort.add(0);
        int i=1;
        while(i<=v_size)
        {
            Object v = Collections.max(g.vertexSet(), comp);
            g.removeVertex(v);
            v_sort.add((Integer)v);
            i++;
        }
    }
public  static  int iter=0;

    public static void min_vertex_cover(SimpleGraph g, int index, Set<Integer> set1){

        if (index > no_of_vertex || (set1.size()+MaximumCover(g)) > best_sol){
            return;
        }
        if( g.edgeSet().size()  == 0 ) {
            if (set1.size() < best_sol) {
                best_sol = set1.size();
                best_set = new HashSet<>(set1);
                System.out.println(best_sol);
                System.out.println(set1.toString());
            }
            //System.out.println(iter);
            //System.out.println(set1.toString());

            iter+=1;
            if (iter>5000) {
                System.out.println(iter);
                System.out.println(set1.toString());
                System.exit(0);
            }        return;
        }

        //storing the nearest neighbhours
        Object k = Graphs.neighborListOf(g,v_sort.get(index));

        //removing vertex and adding it to the set
        g.removeVertex(v_sort.get(index));
        set1.add(v_sort.get(index));

        //recursion
        min_vertex_cover(g,index+1,set1);

        //add back the vertex to graph and add its edges, then remove it from the set
        set1.remove(v_sort.get(index));
        g.addVertex(v_sort.get(index));
        for(int i =0;i<((ArrayList)k).size();i++)
            g.addEdge(v_sort.get(index),((ArrayList)k).get(i));

        //recursion
        min_vertex_cover(g,index+1,set1);
    }


    public static void main(String args[]){

        File folder = new File("Data");
        File[] files = folder.listFiles(); //get data files

        for (int i = 1; i < files.length; i++) {

            File cur = files[i];
            Scanner s = null;
            try {
                s = new Scanner(cur); //open data file
            } catch (Exception e) {
                //System.out.println(e);
            }

            if (s != null) {

            SimpleGraph<Integer, DefaultEdge> g = (SimpleGraph<Integer, DefaultEdge>) GraphCreate(s);
            max_cover = MaximumCover(g);
            lower_bound_g = max_cover;
            upper_bound_g = (int)2*lower_bound_g;
            best_sol = upper_bound_g+1;
            sort_v(g);
            //System.out.println(lower_bound_g);
            //System.out.println(upper_bound_g);

            Set<Integer> set_v =new HashSet<>();
            min_vertex_cover(g,1,set_v);

            //System.out.println("hi");
            System.out.println("Count of vertex "+ best_sol);
            System.out.println("set of vertex "+ best_set.toString());


            }

            else {
                System.out.println("Something went wrong, scanner is null");
            }

        }
    }


}

