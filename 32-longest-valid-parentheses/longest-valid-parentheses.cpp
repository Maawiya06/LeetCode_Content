class Solution {
public:
    int longestValidParentheses(string s) {
        stack<int> st;
        st.push(-1);
        int lenMax = 0;

        for(int i = 0; i < s.length(); i++){
            if(s[i] == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(!st.empty()){
                    lenMax = max(lenMax, i - st.top());
                }
                else{
                    st.push(i);
                }
            }
        }
        return lenMax;
    }
};