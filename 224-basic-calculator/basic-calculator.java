class Solution {
    public int calculate(String s) {
        return evaluate(s.toCharArray(), new int[]{0});
    }

    private int evaluate(char[] chars, int[] index){
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';

        while(index[0] < chars.length){
            char ch = chars[index[0]];

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            if(ch == '('){
                index[0]++;
                num  = evaluate(chars, index);
            }
            if((!Character.isDigit(ch) && ch != ' ' && ch != '(') || index[0] == chars.length - 1){
                if(sign == '+'){
                    st.push(num);
                }
                else if(sign == '-'){
                    st.push(-num);
                }
                sign = ch;
                num  = 0;
            }

            if(ch == ')'){
                break;
            }

            index[0]++;
        }

        int sum = 0;
        for(int val : st){
            sum += val;
        }
        return sum ;
    }
}