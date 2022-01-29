package Lambda;

import java.util.function.*;
import java.util.*;

class Ex14_2 {
    public static void main(String[] args) {
        Supplier<Integer>  s = ()-> (int)(Math.random()*100)+1; // 1~100 난수
        Consumer<Integer>  c = i -> System.out.print(i+", ");
        Predicate<Integer> p = i -> i%2==0; // 짝수인지 검사.
        Function<Integer, Integer> f = i -> i/10*10; // i의 1의 자리를 없앤다.

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);    // list를 random값으로 채운다
        System.out.println(list);
        printEvenNum(p, c, list);   // 짝수를 출력
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());

        for(T i : list) {
            newList.add(f.apply(i));    // 일의 자리를 없애서 새로운 list에 저장.
        }

        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for(T i : list) {
            if(p.test(i))   // 짝수인지 검사
                c.accept(i);// 화면에 i 출력 (위 Consumer 참고)
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for(int i=0;i<10;i++) {
            list.add(s.get());  // Supplier로 부터 1~100의 난수 받아서 list에 추가
        }
    }
}