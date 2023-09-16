package com.education;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
     int[] arr = {4, 6, -4, 5, 5, 6, 7, -4, 4};
     int[] arr2 = {4, 6, -4, 5, 5, 6, 7, 9, 7, -4, 4};


     System.out.println(getUniqNumber(arr));
     System.out.println(getUniqNumber(arr2));
    }

    public static int getUniqNumber(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        for(int i = 0; i < arr.length - 1;i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] != arr[j]) {
                    res = arr[j];
                    break;
                }
            }
        }
        return res;
    }
}
