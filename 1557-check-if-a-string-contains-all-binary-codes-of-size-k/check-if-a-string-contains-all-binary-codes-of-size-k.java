class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> st = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++){
            st.add(s.substring(i, i + k));
        }
        return st.size() == (int)Math.pow(2, k);
    }
}