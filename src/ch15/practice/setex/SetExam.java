package ch15.practice.setex;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
    public SetExam(){

        Set<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("Python");
        hashSet.add("JavaScript");
        hashSet.add("Java");
        System.out.println(hashSet);
        System.out.println();


        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(40);
        treeSet.add(20);
        treeSet.add(10);
        System.out.println("Treeset(정렬됨) : " + treeSet);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("첫째");
        linkedHashSet.add("셋째");
        linkedHashSet.add("둘째");
        linkedHashSet.add("첫째");

        System.out.println("LinedHashSet 순서유지" + linkedHashSet);

    }
}
