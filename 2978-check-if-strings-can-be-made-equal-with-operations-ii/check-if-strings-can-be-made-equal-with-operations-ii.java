class Solution {
    public boolean checkStrings(String s1, String s2) {
        List<Character> even1 = new ArrayList<>();
        List<Character> odd1 = new ArrayList<>();
        List<Character> even2 = new ArrayList<>();
        List<Character> odd2 = new ArrayList<>();

        for(int i = 0; i < s1.length(); i++){
            if(i % 2 == 0){
                even1.add(s1.charAt(i));
                even2.add(s2.charAt(i));
            }
            else{
                odd1.add(s1.charAt(i));
                odd2.add(s2.charAt(i));
            }
        }

        Collections.sort(even1);
        Collections.sort(even2);
        Collections.sort(odd1);
        Collections.sort(odd2);

        return even1.equals(even2) && odd1.equals(odd2);
    }
}