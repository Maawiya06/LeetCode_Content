class Solution {
    public String makeLargestSpecial(String s) {
        List<String> ans = new ArrayList<>();

        int start = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
            else{
                count--;
            }

            if(count == 0){
                String inner =  makeLargestSpecial(s.substring(start + 1, i));
                ans.add("1" + inner + "0");
                start = i + 1;
            }
        }

        Collections.sort(ans, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for(String str : ans){
            result.append(str);
        }
        return result.toString();
    }    
}