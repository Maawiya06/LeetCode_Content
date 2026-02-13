class Solution {
    private int Count1(char[] arr){
        int ans = 0;
        char ch = arr[0];
        int count = 0;

        for(char val : arr){
            if(val == ch){
                count++;
            }
            else{
                ch = val;
                count = 1;
            }

            ans = Math.max(ans , count);
        }
        return ans;
    }

    private int Count2(int n1, int n2, char[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, - 1);

        int sum = 0;
        int ans = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n1){
                sum++;
            }
            else if(arr[i] == n2){
                sum--;
            }
            else{
                map = new HashMap<>();
                sum = 0;
                map.put(0, i);
                continue;
            }

            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }

        return ans;
    }

    private int Count3(char[] ch){
        int a = 0, b = 0, c = 0;
        int maxLen = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", -1);

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'a') a++;
            else if (ch[i] == 'b') b++;
            else c++;

            int diff1 = a - b;
            int diff2 = a - c;        
            String key = diff1 + "," + diff2;

            if (map.containsKey(key)) {
                maxLen = Math.max(maxLen, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return maxLen;
    }
    public int longestBalanced(String s) {
        int n = s.length();
        if(n ==0) return 0;

        char[] ch = s.toCharArray();
        int ans = 0;

        ans = Math.max(ans, Count1(ch));

        ans = Math.max(ans, Count2('a', 'b', ch));
        ans = Math.max(ans, Count2('b', 'c', ch));
        ans = Math.max(ans, Count2('c', 'a', ch));

        ans = Math.max(ans, Count3(ch));

        return ans;
    }
}
