package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Lab2 {
    public static void main(String[] args) {
        List<Integer> a1 = Arrays.asList(7, 6, 2, 4, 4, 1);
        List<Integer> a2 = Arrays.asList(7, 6, 2, 4, 1);
        List<Integer> a3 = Arrays.asList(3, 4, 2, 3, 4, 7, 4);
        List<Integer> a4 = Arrays.asList(1, 6, 2, 8, 2, 9);
        List<Integer> a5 = Arrays.asList(4);
        List<Integer> a6 = Arrays.asList(3);


        mapReduce2(a1);
        mapReduce2(a2);
        mapReduce2(a3);
        mapReduce2(a4);
        mapReduce2(a5);
        mapReduce2(a6);
    }

    private static void mapReduce(List<Integer> list) {
        boolean rs = !list.stream().map(x -> {
            if (x == 3) return 1;
            if (x == 4) return -1;
            return 2;
        }).reduce(2, (a, b) -> {
            if (a == 2) return b;
            if (a * b == -1) return 3;
            return a;
        }).equals(-1);
        System.out.println(rs);
    }


    private static void mapReduce2(List<Integer> list) {
        boolean rs = list.stream().reduce(1, (a,b) -> {
          if (b == 3) return 2;
          if (b == 4 && a == 1) return 0;
          return a;
        }) > 0;
        System.out.println(rs);
    }


}
