package leetcode.fabu.day2;

import java.util.Arrays;

/**
 * 1175. 质数排列
 * https://leetcode.cn/problems/prime-arrangements/
 */
public class YbNumPrimeArrangements {
    public static void main(String[] args) {
        YbNumPrimeArrangements yb = new YbNumPrimeArrangements();
        System.out.println(yb.numPrimeArrangements(100));
    }

    static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        int iPrimes = countPrimes(n);
        System.out.println(iPrimes);
        return (int) (factorial(iPrimes) * factorial(n - iPrimes) % MOD);
    }

    private int countPrimes(int n) {
        boolean[] isPrim = new boolean[n+1];
        int result = 0;
        Arrays.fill(isPrim, true);
        for (int i = 2; i <= n; i++) {
            if (isPrim[i]) {
                result++;
                for (long j = (long) i * (long) i; j <= n; j += i) {
                    isPrim[(int) j] = false;
                }
            }
        }
        return result;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
            res = res % MOD;
        }
        return res;
    }

}
