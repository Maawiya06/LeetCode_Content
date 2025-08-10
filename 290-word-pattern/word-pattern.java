class Solution {
    public boolean wordPattern(String pattern, String s) {
        
       String[] word = s.split(" ");

       // base case
       if(pattern.length() != word.length) return false;

       Map<Character, String> map = new HashMap<>();
       Map<String, Character> reverse = new HashMap<>();

       for(int i = 0; i < pattern.length(); i++){
           char p = pattern.charAt(i);
           String w = word[i];

           // if already mapped
           if(map.containsKey(p) && !map.get(p).equals(w)) return false;
           if(reverse.containsKey(w) && reverse.get(w) != p) return false;

           // map them 
           map.put(p, w);
           reverse.put(w, p);
       }    

       return true;
    }
}