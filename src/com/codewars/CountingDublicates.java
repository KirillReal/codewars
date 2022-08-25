package com.codewars;

public class CountingDublicates {
    static final int NO_OF_CHARS = 256;
    public static int duplicateCount(String text) {
        int result = 0;
        int count[] = new int[NO_OF_CHARS];
        for(int i = 0; i < text.length(); ++i){
            count[Character.toLowerCase(text.charAt(i))]++;
        }
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if(count[i] > 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int test0 = duplicateCount("aabbcde");
        System.out.println(test0);
        int test = duplicateCount("reallyLongStringContainingDuplicates");
        System.out.println(test);
        int test1 = duplicateCount("indivisibility");
        System.out.println(test1);
        int test2 = duplicateCount("abcde");
        System.out.println(test2);
    }
}
