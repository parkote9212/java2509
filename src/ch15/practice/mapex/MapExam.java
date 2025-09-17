package ch15.practice.mapex;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExam {
    public MapExam(){

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("사과",1000);
        hashMap.put("바나나",500);
        hashMap.put("오렌지",800);
        hashMap.put("사과",1200); //기준값 덮어쓰기

        System.out.println("HashMap : " + hashMap);
        System.out.println("사과 가격 : " + hashMap.get("사과"));

        System.out.print("키 : ");
        for (String key : hashMap.keySet()){
            System.out.print(key + " ");
        }
        System.out.println();
        System.out.print("값 : ");
        for (Integer value : hashMap.values()){
            System.out.print(value + " ");
        }

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("서울", "Seoul");
        treeMap.put("부산", "Busan");
        treeMap.put("대구", "Daegu");
        treeMap.put("인천", "Incheon");
        System.out.println("Treemap (키정렬) : " + treeMap);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "셋");
        linkedHashMap.put(1, "하나");
        linkedHashMap.put(2, "둘");
        System.out.println("LinkedHashMap (순서유지) : " + linkedHashMap);
    }
}
