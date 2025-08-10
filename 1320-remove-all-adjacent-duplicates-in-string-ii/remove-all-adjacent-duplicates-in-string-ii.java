class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Character> charst = new Stack<>();
        Stack<Integer> countst = new Stack<>();


        for(char c : s.toCharArray()){
            if(!charst.isEmpty() && charst.peek() == c){
                countst.push(countst.pop() + 1);

                if(countst.peek() == k){
                    charst.pop();
                    countst.pop();
                }
            }
            else{
                charst.push(c);
                countst.push(1);
            }
        }

        // rebuild the string
        StringBuilder sb = new StringBuilder();
        while(!charst.isEmpty()){
            char ch = charst.pop();
            int cnt = countst.pop();
            for(int i = 0; i < cnt; i++){
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}