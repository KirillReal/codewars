package com.codewars;

import java.util.Arrays;

public class Interview {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, -7, -7, -7, 1, 2, 5, 3, 1, 2};

        int n = getFirstUnique(arr);
        System.out.println("Найдено уникальное значение " + n);
    }

    private static int getFirstUnique(int arr[]) {
        Integer rsl = null;
        boolean b;
        for (int i = 0; i <= arr.length - 1;i++) {
            b = false;
            for (int j = 0; j <= arr.length - 1; j++) {
                if (i != j) {
                    if (arr[i] == arr[j]) {
                        b = true;
                        break;
                    }
                }
            }
            if(!b) {
                rsl = arr[i];
                return rsl;
            }
        }
        throw new NullPointerException("В массиве нет ун значений");
    }
}
