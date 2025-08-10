class Solution {
    public String removeStars(String s) {
        
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '*'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(char c : st){
            ans.append(c);
        }
        return ans.toString();
    }
}