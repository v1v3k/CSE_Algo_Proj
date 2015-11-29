import java.util.*;
import java.io.*;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

public class main {
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
                    //long startTime_dc = System.nanoTime();
                    //String[] newline_dc = dc(cursplitint, 0, n - 1); //run divide and conquer
                    //long endTime_dc = System.nanoTime();
                    //double time_dc = Math.round((endTime_dc - startTime_dc)*100.00)/100.00; //correct format
                    //System.out.println("dc " + (Math.round(Double.parseDouble(newline_dc[0])*100.00)/100.00) + ", " + newline_dc[1] + ", " + newline_dc[2] + ", " + time_dc);
                    //newline_dc[1] = Integer.toString(Integer.parseInt(newline_dc[1]) + 1); //NEED TO ADD 1 BECAUSE JAVA INDEX STARTS AT 0
                    //newline_dc[2] = Integer.toString(Integer.parseInt(newline_dc[2]) + 1);
                    //wr_dc.println((Math.round(Double.parseDouble(newline_dc[0])*100.00)/100.00) + ", " + newline_dc[1] + ", " + newline_dc[2] + ", " + time_dc);
            
                    //long startTime_dp = System.nanoTime();
                    //String[] newline_dp = dp(cursplitint, 0, n - 1);
                    //long endTime_dp = System.nanoTime(); //dynamic programming
                    //double time_dp = Math.round((endTime_dp - startTime_dp)*100.00)/100.00;
                    //System.out.println("dp " + (Math.round(Double.parseDouble(newline_dp[0])*100.00)/100.00) + ", " + newline_dp[1] + ", " + newline_dp[2] + ", " + time_dp);
                    //newline_dp[1] = Integer.toString(Integer.parseInt(newline_dp[1]) + 1); //NEED TO ADD 1 BECAUSE JAVA INDEX STARTS AT 0
                    //newline_dp[2] = Integer.toString(Integer.parseInt(newline_dp[2]) + 1);
                    //wr_dp.println((Math.round(Double.parseDouble(newline_dp[0])*100.00)/100.00) + ", " + newline_dp[1] + ", " + newline_dp[2] + ", " + time_dp);                   
                    
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

