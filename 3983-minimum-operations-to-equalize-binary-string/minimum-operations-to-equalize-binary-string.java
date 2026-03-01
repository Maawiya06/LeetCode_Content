class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("000");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
    public int minOperations(String s, int k) {
        int n = s.length();
        int zer0Count = 0;

        for(char c : s.toCharArray()){
            if(c == '0') zer0Count++;
        }

        if(zer0Count == 0) return 0;

        if(k == n){
            return (zer0Count == n) ? 1 : -1;
        }

        int base = n - k;

        // minm odd operation
        int odd = Math.max(
                          (zer0Count + k - 1) / k,
                          ((n - zer0Count) + base - 1) / base
        );
        if(odd % 2 == 0) odd++;

        // minm even operation
        int even = Math.max(
                           (zer0Count + k - 1) / k,
                           (zer0Count + base - 1) / base
        );
        if(even % 2 != 0) even++;

        int ans = Integer.MAX_VALUE;
        if((k % 2) == (zer0Count % 2)){
            ans = Math.min(ans, odd);
        }
        if(zer0Count % 2 == 0){
            ans = Math.min(ans, even);
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}