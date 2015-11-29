package com.company;

/**
 * Created by george on 11/16/15.
 */
public class rec_test {

    static int global_Var = 10;
    public static void rec(int i)
    {
        if (i<20)
        {
            i=i+1;
            rec(i);
        }
        if (i==20){
            global_Var=20;
        }
        System.out.println(i);
        System.out.println(global_Var);
    }

    public static void main(String args[]){
        System.out.println("testing");
        rec(1);
    }
}
