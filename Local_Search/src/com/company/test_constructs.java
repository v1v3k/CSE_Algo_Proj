package com.company;
import java.util.*;
/**
 * Created by george on 11/16/15.
 */
public class test_constructs {

    public static  void main(String args[]){

        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        Set <Integer> s2 = new HashSet<>(s1);

        s1.add(2);
        System.out.print(s2.toString());
        System.out.print(s1.toString());
    }

}


