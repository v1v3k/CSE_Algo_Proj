package com.company;

/**
 * Created by george on 11/11/15.
 */
import java.util.*;
import java.io.*;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

public class test2 {
    public static void main(String[] args) {
        UndirectedGraph<Integer, DefaultEdge> g =
                new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);


        File folder = new File("Data");
        File[] files = folder.listFiles(); //get data files
        for (int i = 1; i < files.length; i++) {
            File cur = files[i];
            Scanner s = null;
            try {
                s = new Scanner(cur); //open data file
            } catch (Exception e) {
                System.out.println(e);
            }
            if (s != null) {
                String first = s.nextLine();
                String[] firstsplit = first.split(","); //first line is different format than rest
                int numberVertex = Integer.parseInt(firstsplit[0]);
                int numberEdges = Integer.parseInt(firstsplit[1]);
                int directed = Integer.parseInt(firstsplit[2]);
                PrintWriter wr_bb = null; //need to write outputs
                PrintWriter wr_h = null;
                PrintWriter wr_ls = null;
                try {
                    wr_bb = new PrintWriter("output/rbach3_output_bb_" + ".txt", "UTF-8");
                    wr_h = new PrintWriter("output/rbach3_output_h_" + ".txt", "UTF-8");
                    wr_ls = new PrintWriter("output/rbach3_output_ls_" + ".txt", "UTF-8");
                } catch (Exception e) {
                    System.out.println(e);
                }
                while (s.hasNextLine()) { //iterate file
                    String curLine = s.nextLine();
                    String[] cursplit = curLine.split(",");
                    int[] cursplitint = new int[cursplit.length]; //get data
                    for (int j=0; j < cursplit.length; j++) {
                        cursplitint[j] = Integer.parseInt(cursplit[j]); //get integer for data
                        g.addVertex(cursplitint[j]);

                    }

                    int vertex = cursplitint[0];
                    for (int j = 1; j < cursplitint.length; j++) {
                        g.addEdge(vertex, cursplitint[j]);
                    }
                }
                wr_bb.close();
                wr_h.close();
                wr_ls.close();
            } else {
                System.out.println("Something went wrong, scanner is null");
            }
        }
    }

}

