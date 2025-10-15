class Solution {
    List<String> solve(String s, Map<String, Boolean> dict, int i) {
        if (i == s.length()) {
            List<String> base = new ArrayList<>();
            base.add(""); 
            return base;
        }

        List<String> ans = new ArrayList<>();
        String word = "";

        for (int j = i; j < s.length(); j++) {
            word += s.charAt(j);

            if (!dict.containsKey(word)) continue;

            List<String> right = solve(s, dict, j + 1);

            for (String eachRightPart : right) {
                if (eachRightPart.equals(""))
                    ans.add(word);
                else
                    ans.add(word + " " + eachRightPart);
            }
        }
        return ans;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> dict = new HashMap<>();
        for (String word : wordDict) dict.put(word, true);

        return solve(s, dict, 0);
    }
}
