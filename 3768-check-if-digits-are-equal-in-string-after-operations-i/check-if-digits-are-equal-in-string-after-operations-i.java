class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            int n = s.length();
            
            StringBuilder ans = new StringBuilder();

            for(int i = 0; i < n - 1; i++){
                int a1 = s.charAt(i) - '0';
                int a2 = s.charAt(i + 1) - '0';

                int result = (a1 + a2) % 10;
                ans.append(result);
            }
            s = ans.toString();

       }
       return s.charAt(0) == s.charAt(1);
    }
}