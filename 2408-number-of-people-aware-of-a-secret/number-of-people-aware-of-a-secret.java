import java.util.*;

class Solution {
    static class Pair {
        int time;
        int count;

        Pair(int time, int count) {
            this.time = time;
            this.count = count;
        }
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int curr = 0; // active spreaders
        int ans = 1;  // people who know about the secret
        final int MOD = 1_000_000_007;

        Queue<Pair> delayq = new LinkedList<>();
        Queue<Pair> forgetq = new LinkedList<>();

        delayq.add(new Pair(1, 1));
        forgetq.add(new Pair(1, 1));

        for (int i = 2; i <= n; i++) {
            // Step 1: Remove those who forget the secret
            while (!forgetq.isEmpty() && forgetq.peek().time + forget <= i) {
                Pair peek = forgetq.poll();
                ans = (ans - peek.count + MOD) % MOD;
                curr = (curr - peek.count + MOD) % MOD;
            }

            // Step 2: Add new active spreaders
            while (!delayq.isEmpty() && delayq.peek().time + delay <= i) {
                Pair peek = delayq.poll();
                curr = (curr + peek.count) % MOD;
            }

            // Step 3: Spread the secret
            if (curr > 0) {
                ans = (ans + curr) % MOD;
                delayq.add(new Pair(i, curr));
                forgetq.add(new Pair(i, curr));
            }
        }

        return ans;
    }
}
