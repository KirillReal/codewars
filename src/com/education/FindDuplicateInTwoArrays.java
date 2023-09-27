package com.education;

import java.util.*;
import java.util.stream.IntStream;

public class FindDuplicateInTwoArrays {
    public static void main(String[] args) {

        var v1 = new ArrayList<Integer>();
        List<? extends Number> v2 = v1;

        var c1 = new ArrayList<Number>();
        List<? super Integer> c2 = c1;

        for (int i = 0; i < 10; i++) {

            final var a = makeArray();
            final var b = makeArray();

            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));

            System.out.println("Duplicates: " + Arrays.toString(findDuplicates(a, b)));

        }
    }

    public static int[] findDuplicates(int[] a, int[] b) {

        //
        // Вернуть все дубликаты которые встречаются среди первого или второго массива.
        // Дубликатами считаются числа, которые находятся либо в одинаковых, либо в разных массивах.
        // Дубликаты должны быть возвращены в том же порядке в котором они встречаются сначала в первом массиве, затем во втором
        //
        // Например:
        // a = [4, 4, 3, 9, 8]
        // b = [2, 1, 2, 9]
        //
        // Ожидаемый результат:
        // [4, 4, 9, 2, 2, 9]
        //
        List<Integer> resList = new ArrayList<>(IntStream.of(a).boxed().toList());
        resList.addAll(IntStream.of(b).boxed().toList());
        List<Integer> result = resList.stream().filter(i -> Collections.frequency(resList, i) > 1).toList();
        int[] res = result.stream().mapToInt(i -> i).toArray();
        return res;
    }

    private static int[] makeArray() {
        final var random = new Random();
        final var len = random.nextInt(8) + 3;
        return IntStream.range(0, len).map(i -> random.nextInt(10)).toArray();
    }
}
