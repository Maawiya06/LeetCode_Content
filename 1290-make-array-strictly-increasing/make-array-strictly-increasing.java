class Solution {
    
    static final int INF = 2000000001; 
    int findNextGreater(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        int ans = arr.length; 

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;    
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans; 
    }

    int solve(int[] arr1, int[] arr2, int prev, int i, Map<String, Integer> dp) {
        if (i == arr1.length) {
            return 0;
        }

        String key = prev + "," + i;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int ans = INF;
        if (arr1[i] > prev) {
            ans = Math.min(ans, solve(arr1, arr2, arr1[i], i + 1, dp));
        }        
        
        int replaceIndex = findNextGreater(arr2, prev);
        
        if (replaceIndex < arr2.length) {
            int next = arr2[replaceIndex];
            int res = solve(arr1, arr2, next, i + 1, dp);
            if (res != INF) {
                ans = Math.min(ans, 1 + res);
            }
        }
        dp.put(key, ans);
        return ans;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        List<Integer> uniqueList = new ArrayList<>();
        if (arr2.length > 0) {
            uniqueList.add(arr2[0]);
            for (int k = 1; k < arr2.length; k++) {
                if (arr2[k] != arr2[k - 1]) {
                    uniqueList.add(arr2[k]);
                }
            }
        }
        int[] uniqueArr2 = new int[uniqueList.size()];
        for (int k = 0; k < uniqueList.size(); k++) {
            uniqueArr2[k] = uniqueList.get(k);
        }
        Map<String, Integer> dp = new HashMap<>();
        int ans = solve(arr1, uniqueArr2, -1, 0, dp);
        
        return ans >= INF ? -1 : ans;
    }
}