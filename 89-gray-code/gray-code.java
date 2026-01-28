class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int ans = 1 << n;
        for(int i = 0; i < ans; i++){
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}