package com.codewars;

import java.util.List;

public class KrimesSteps {
   static int countPrimes(long num) {
        long i = 2;
        int count = 0;
        while (i * i <= num) {
            while(num % i == 0) {
                num /= i;
                count++;
            }
            i++;
        }
        if(num != 1) count++;
        return count;
    }
/*
    public static List<long[]> kprimesStep(int k, int step, long start, long nd) {
        if(k < 1 || start > nd || step < 1) {
            return null;
        }
        List<long[]> res;
        for(long i = start;i <= nd - step; i++) {
            if(countPrimes(i) == k && countPrimes(i + step) == k) {

            }
        }

        return res;
    }

 */
}
