class Solution {
    int solveByBinarySearch(int[][] envelopes){
        List<Integer> list = new ArrayList<>();

        for(int[] envalop : envelopes){
            int height = envalop[1];

            int index = Collections.binarySearch(list, height);

            if(index < 0) {
              index = -(index + 1);
            }

            if(index == list.size()){
                list.add(height);
            }
            else{
                list.set(index, height);
            }
        }

        return list.size();
    }
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int ans = solveByBinarySearch(envelopes);
        return ans;
    }
}