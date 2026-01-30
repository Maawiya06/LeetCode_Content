class Solution {
    public void solve(String s, int i, List<String> result, List<String> address){
        if(address.size() == 4){
            if(i == s.length()){
                result.add(String.join(".", address));
            }
        }
        else{
            for(int j = i + 1; j <= i + 3 && j <= s.length(); j++){
                String nextInt = s.substring(i, j);
                if(Integer.parseInt(nextInt) <= 255 && (nextInt.equals("0") || !nextInt.startsWith("0"))){
                    address.add(nextInt);
                    solve(s, j, result, address);
                    address.remove(address.size() - 1);
                }
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> address = new ArrayList<>();
        solve(s, 0, result, address);
        return result;
    }
}