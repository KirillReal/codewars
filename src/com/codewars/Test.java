package com.codewars;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 5, 10, 10, 16, 22, 22, 23};
        removeDuplicates(arr);
    }

    public static void removeDuplicates(int[] a)
    {
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] != a[i]) {
                a[j++] = a[i];
                System.out.println(a[i]);
            }
        }

        a[j++] = a[a.length - 1];
    }

}
