import java.util.*;

class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        double[] answer = new double[cars.length];
        Arrays.fill(answer, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = cars.length - 1; i >= 0; i--) {
            // Remove cars from stack that are faster or equal speed
            while (!st.isEmpty() && cars[st.peek()][1] >= cars[i][1]) {
                st.pop();
            }

            while (!st.isEmpty()) {
                double colTime = (double) (cars[st.peek()][0] - cars[i][0]) / (cars[i][1] - cars[st.peek()][1]);
                if (answer[st.peek()] == -1 || colTime <= answer[st.peek()]) {
                    answer[i] = colTime;
                    break;
                }
                st.pop();
            }

            st.push(i);
        }

        return answer;
    }
}
