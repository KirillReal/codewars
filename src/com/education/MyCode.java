package com.education;

import java.util.*;

public class MyCode {
        public static void main(String[] args) {
            List<Object> data = Arrays.asList("A", "B", Arrays.asList("D", Arrays.asList("E", "F")), "C");
            System.out.println(data);
            //printList(data,1);
            System.out.println(printFilter(data, 1));
        }

    //1 решение
    public static String printFilter(List<Object> o, int count) {
        StringBuilder str = new StringBuilder();
        for (Object obj : o) {
            if (obj instanceof String) {
                str.append("-".repeat(Math.max(0, count)));
                str.append(obj).append("\n");
            } else {
                str.append(printFilter((List<Object>) obj, count + 1));
            }
        }
        return str.toString();
        //        System.out.println(str);
    }
    //2 решение
    public static void printList(List<Object> data, int lvl){
        for(Object object : data){
            if (object instanceof List){
                printList((List<Object>) object, lvl+1);
            }else{
                for(int i=0; i<lvl; i++){
                    System.out.print("-");
                }
                System.out.println(" " + object);
            }
        }
    }

    // Напечатать лист data с использованием рекурсии
    // формат
    /*
     * - A
     * - B
     * -- D
     * --- E
     * --- F
     * - C
     */


}
