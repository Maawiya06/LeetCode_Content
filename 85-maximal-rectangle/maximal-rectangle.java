import java.util.*;

class Solution {

    public int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public int[] prevSmallerElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] next = nextSmallerElement(heights);
        int[] prev = prevSmallerElement(heights);

        // Update -1 in 'next' with length (i.e., right end of histogram)
        for (int i = 0; i < n; i++) {
            if (next[i] == -1) {
                next[i] = n;
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = next[i] - prev[i] - 1;
            int length = heights[i];
            int currArea = width * length;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        List<List<Integer>> v = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                t.add(matrix[i][j] - '0');
            }
            v.add(t);
        }

        int area = largestRectangleArea(listToArray(v.get(0)));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v.get(i).get(j) != 0) {
                    v.get(i).set(j, v.get(i).get(j) + v.get(i - 1).get(j));
                } else {
                    v.get(i).set(j, 0);
                }
            }
            area = Math.max(area, largestRectangleArea(listToArray(v.get(i))));
        }

        return area;
    }

    private int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
