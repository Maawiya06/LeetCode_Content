class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, -1); // default value
        Stack<Integer> st = new Stack<>();

        for(int i = 2 * n - 1; i >= 0; i--){

            int num = nums[i % n];

            while(!st.isEmpty() && nums[st.peek()] <= num){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i % n] = nums[st.peek()];
            }

            st.push(i % n);
        }

        return res;
    }
}