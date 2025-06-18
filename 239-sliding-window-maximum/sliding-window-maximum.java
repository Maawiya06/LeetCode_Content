class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            // remove elements out of this window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            // remove all elements smaller than current from the deque
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            // add current element index
            dq.addLast(i);

            // add the maximum of the current window to result
            if(i >= k - 1){
                result.add(nums[dq.peekFirst()]);
            }
        }

        // Convert ArrayList<Integer> to int[]
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }

        return ans;
    }
}
