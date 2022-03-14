package collection;

import java.util.ArrayList;
import java.util.Collections;

public class Ex11_1 {
    public static void main(String[] args) {
        //기본 길이(용량, capacity)가 10인 ArrayList를 생성
        ArrayList list1 = new ArrayList(10);
        // ArrayList에는 객체만 저장 가능 하지만 autoboxing에 의해서 기본형이 참조형으로 변환

        list1.add(5);
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1,4));
        // sublist에 의해 만들어진 list는 읽기 전용.  ArrayList(Collection c)를 활용 한것.
        print(list1, list2);

        // Collection은 인터페이스, Collections는 유틸 클래스
        Collections.sort(list1);	// list1과 list2를 정렬한다.
        Collections.sort(list2);	// Collections.sort(List l)
        print(list1, list2);

        // 모든 요소 포함 하고 있는지 물어보는것.
        System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");  // 추가할 위치 지정. 자리이동 필요.
        print(list1, list2);

        list2.set(3, "AA");  // 바꿈
        print(list1, list2);

        list1.add(0,"1");
        // indexOf()는 지정된 객체의 위치(인덱스)를 알려준다.
        System.out.println("index=" + list1.indexOf(new Integer(1)));

        list1.remove(1); // 인덱스가 1인 객체를 삭제
        list1.remove(new Integer(1)); // 1을 삭제

        // list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
        System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
        print(list1, list2);


        //  list2에서 list1에 포함된 객체들을 삭제한다.
        for(int i= list2.size()-1; i >= 0; i--) {
            if(list1.contains(list2.get(i)))
                list2.remove(i);
        }
        print(list1, list2);
    } // main의 끝

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
        System.out.println();
    }
} // class