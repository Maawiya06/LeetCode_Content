class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int waterTrapped = 0;
        int current = 0;

        while (current < height.length) {
            // while stack is not empty and current bar is greater than top of stack
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop(); // index of the valley
                if (stack.isEmpty()) break;

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                waterTrapped += distance * boundedHeight;
            }
            stack.push(current++);
        }

        return waterTrapped;
    }
}
