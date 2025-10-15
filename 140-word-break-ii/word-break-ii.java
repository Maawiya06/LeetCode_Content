class Solution {
    List<String> solve(String s, Map<String, Boolean> dict, int i, Map<Integer, List<String>> dp) {
        if (i == s.length()) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        List<String> ans = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();
        
        for (int j = i; j < s.length(); j++) {
            wordBuilder.append(s.charAt(j));
            String word = wordBuilder.toString();

            if (!dict.containsKey(word)) {
                continue;
            }

            List<String> right = solve(s, dict, j + 1, dp);

            
            for (String eachRightPart : right) {
                if (eachRightPart.equals("")) {
                    ans.add(word); 
                } else {
                    ans.add(word + " " + eachRightPart);
                }
            }
        }
        
        
        dp.put(i, ans);
        return ans;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> dict = new HashMap<>();
        for (String word : wordDict) {
            dict.put(word, true);
        }
        Map<Integer, List<String>> dp = new HashMap<>();
        return solve(s, dict, 0, dp);
    }
}