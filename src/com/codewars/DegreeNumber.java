package com.codewars;

public class DegreeNumber {
    static boolean checkNumberIsDegree(int number, int numDegree) {
        while (number != 1 && number % numDegree == 0 && number > 0) {
            number /= numDegree;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        System.out.println(checkNumberIsDegree(27,3));
        System.out.println(checkNumberIsDegree(8,2));
        System.out.println(checkNumberIsDegree(6,3));
    }
}
