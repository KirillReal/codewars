package com.algorythms;

public class DedublicateString {
    static String deduplicate(String s) {
        char[] arr = s.toCharArray();
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i < arr.length - 1; i++) {
           res.append(arr[i]);
           while(i < arr.length - 1) {
               if (Character.toLowerCase(arr[i]) == Character.toLowerCase(arr[i + 1])) {
                   i++;
               } else {
                   break;
               }
           }
        }
        if(Character.toLowerCase(arr[arr.length-1]) != Character.toLowerCase(arr[arr.length - 2])) {
            res.append(arr[arr.length - 1]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String input = "Зздрррраавствввууй,    Ссссбееерррр!";
        String expected = "Здравствуй, Сбер!";

        String deduplicated = deduplicate(input);
        System.out.println(deduplicated);
        System.out.println(expected.equals(deduplicated));
    }
}
