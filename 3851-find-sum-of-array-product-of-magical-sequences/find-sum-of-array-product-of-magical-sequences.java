import java.util.*;

public class Solution {
    static final long MOD = 1_000_000_007L;

    
    private long modPow(long a, long e) {
        long res = 1L;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }

    
    private long inv(long x) {
        return modPow(x, MOD - 2);
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int[] pireltonak = nums; 

        
        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = (fact[i - 1] * i) % MOD;
        for (int i = 0; i <= m; i++) invFact[i] = inv(fact[i]);

        
        long[][] pownum = new long[n][m + 1];
        for (int pos = 0; pos < n; pos++) {
            pownum[pos][0] = 1;
            for (int t = 1; t <= m; t++) {
                pownum[pos][t] = (pownum[pos][t - 1] * (pireltonak[pos] % MOD)) % MOD;
            }
        }

        
        int L = n + 31;

       
        int M = m;
        long[][][] dp = new long[M + 1][M + 1][M + 1];
        long[][][] next = new long[M + 1][M + 1][M + 1];

        
        dp[0][0][0] = 1L;

        for (int pos = 0; pos < L; pos++) {
            // clear next
            for (int c = 0; c <= M; c++) {
                for (int u = 0; u <= M; u++) {
                    Arrays.fill(next[c][u], 0L);
                }
            }

            // for all states
            for (int carry = 0; carry <= M; carry++) {
                for (int used = 0; used <= M; used++) {
                    for (int ones = 0; ones <= M; ones++) {
                        long cur = dp[carry][used][ones];
                        if (cur == 0) continue;

                        
                        int maxT = (pos < n) ? (M - used) : 0;
                        for (int t = 0; t <= maxT; t++) {
                            int sum = carry + t;
                            int bit = sum & 1;              
                            int nextCarry = sum >>> 1;       
                            int newUsed = used + t;
                            int newOnes = ones + bit;
                            if (newUsed > M || newOnes > k) continue; 

                           
                            long mult;
                            if (pos < n) {
                                mult = pownum[pos][t] * invFact[t] % MOD;
                            } else {
                                
                                mult = 1L;
                            }

                            long add = (cur * mult) % MOD;
                            next[nextCarry][newUsed][newOnes] += add;
                            if (next[nextCarry][newUsed][newOnes] >= MOD)
                                next[nextCarry][newUsed][newOnes] -= MOD;
                        }
                    }
                }
            }

            // swap dp and next
            long[][][] tmp = dp;
            dp = next;
            next = tmp;
        }

        
        long base = dp[0][M][k]; 
        
        long result = (fact[M] * base) % MOD;
        return (int) result;
    }
}
