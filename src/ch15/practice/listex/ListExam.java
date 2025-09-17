package ch15.practice.listex;

import java.util.ArrayList;
import java.util.List;

public class ListExam {
    public ListExam() {

        List<String> arrList = new ArrayList<String>();
        arrList.add("사과");
        arrList.add("바나나");
        arrList.add("포도");
        arrList.add("낑깡");
        arrList.add("오렌지");

        System.out.println(arrList);
        System.out.println(arrList.get(2));
        System.out.println(arrList.get(3));
        arrList.set(0, "파인애플");
        System.out.println(arrList.get(0));
        arrList.add("배");
        arrList.add(0, "딸기");

        System.out.println(arrList);
//        객체 순서X 이름찾기
        System.out.println(arrList.contains("딸기"));
        System.out.println(arrList.isEmpty());
        System.out.println(arrList.size());
        System.out.println(arrList.remove(6));
        System.out.println(arrList);
        System.out.println(arrList.remove("딸기"));
        System.out.println(arrList);
        arrList.clear();
        System.out.println(arrList);
        System.out.println(arrList.isEmpty());
        System.out.println();

        List<Integer> arrList2 = new ArrayList<>();
        arrList2.add(1);
        arrList2.add(2);
        arrList2.add(3);
        System.out.println(arrList2);


    }
}
