package com.codewars;

import java.util.Arrays;
import java.util.HashMap;
//Задача: проверить две строки на изоморфоность
/*
Пояснение: строки s и t называются изоморфными,
если все вхождения каждого символа строки s можно последовательно заменить другим символом и получить строку t.
Порядок символов при этом должен сохраняться, а замена — быть уникальной.
Так, два разных символа строки s нельзя заменить одним и тем же символом из строки t,
а вот одинаковые символы в строке s должны заменяться одним и тем же символом
 */
//Пример: egg, add -> true
//foo, bar -> false
//paper, title -> true

public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphicSecondSolution("egg", "add"));
        System.out.println(isIsomorphicSecondSolution("foo", "bar"));
        System.out.println(isIsomorphicSecondSolution("paper", "title"));
        System.out.println(isIsomorphicSecondSolution("bar", "foo"));
        System.out.println(isIsomorphicSecondSolution("little", "wasswu"));
    }
//1 решение
    public static boolean isIsomorphic(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Boolean> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(map1.containsKey(ch1)) {
                if(map1.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (map2.containsKey(ch2)) {
                    return false;
                } else {
                    map1.put(ch1, ch2);
                    map2.put(ch2, true);
                }
            }
        }
        return true;
    }

    //2 решение
    public static boolean isIsomorphicSecondSolution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(sArr[i])) {
                if(!(map.get(sArr[i]) == tArr[i])) {
                   return false;
                }
            } else {
                if (map.containsValue(tArr[i])) {
                    return false;
                }
            }
            map.put(sArr[i], tArr[i]);
        }
        return true;
    }

//3 решение
    public static boolean isIsomorphicThirdSolution(String s1, String s2) {
        int[] sChar = new int[256];
        int[] tChar = new int[256];
        Arrays.fill(sChar, -1);
        Arrays.fill(tChar, -1);

        for(int i = 0; i < s1.length(); i++){
            int sCharIdx = s1.charAt(i);
            int stCharIdx = s2.charAt(i);
            if (sChar[sCharIdx] == -1 && tChar[stCharIdx] == -1){
                sChar[sCharIdx] = stCharIdx;
                tChar[stCharIdx] = sCharIdx;
            } else if (sChar[sCharIdx] != stCharIdx
                    || tChar[stCharIdx] != sCharIdx) {
                return false;
            }
        }
        return true;
    }
}
