import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = nums2.length - 1; i >= 0; i--){
            int num = nums2[i];

            // if smaller element then pop it
            while(!st.isEmpty() && st.peek() <= num){
                st.pop();
            }

            // is stack empty no greater element
            map.put(num, st.isEmpty() ? -1 : st.peek());

            // pust the current element;
            st.push(num);
        }

        // Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
