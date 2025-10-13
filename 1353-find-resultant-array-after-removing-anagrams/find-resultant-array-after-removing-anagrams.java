class Solution {
    
    private boolean IsAnagrams(String s1, String s2) {
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }

    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<>();
        
        
        if (words.length > 0) {
            result.add(words[0]);
        }

        
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            
            String previousWord = result.get(result.size() - 1);
            
            
            if (!IsAnagrams(currentWord, previousWord)) {
                result.add(currentWord);
            }
        }
        
        return result;
    }
}
