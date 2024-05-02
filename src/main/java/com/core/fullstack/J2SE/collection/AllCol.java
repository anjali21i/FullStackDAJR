package com.core.fullstack.J2SE.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class AllCol {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("Beta");

        List<String> list2 = new LinkedList<>();
        list2.add("Hello");
        list2.add("Beta");

        List<String> list3 = new Vector<>();
        list3.add("Hello");
        list3.add("Beta");

        List<String> list4 = new Stack<>();
        list4.add("Hello");
        list4.add("Beta");









        

        Vector<String> vector = new Vector<>();
        Vector<String> vec2 = new Stack<>();

        Queue<String> q1 = new PriorityQueue<>();
        Queue<String> q2 = new ArrayDeque<>();

        Deque<String> d = new ArrayDeque<>();
        Deque<String> d2 = new LinkedList<>();

        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new LinkedHashSet<String>();
        Set<String> s3 = new TreeSet<String>();
        SortedSet<String> set = new TreeSet<>();

    }

}
