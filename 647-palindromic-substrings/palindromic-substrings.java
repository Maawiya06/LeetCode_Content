class Solution {
    public int expand(String s, int i, int j){
        int count = 0;
        while(i >= 0  && j < s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int totalcount = 0;

        for(int center = 0; center < s.length(); center++){

            int oddans = expand(s, center, center);

            int evenans = expand(s, center, center + 1);

            totalcount = totalcount + oddans + evenans;
        }

        return totalcount;
    }
}