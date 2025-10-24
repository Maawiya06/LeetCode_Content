class Solution {
    boolean isBalanced(int n){
        int[] count = new int[10];
        int temp = n;

        while(temp > 0){
            int digit = temp % 10;
            count[digit]++;
            temp = temp / 10;
        }

        for(int i = 0; i < 10; i++){
            if(count[i] > 0){
                if(count[i] != i){
                    return false;
                }
            }
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while(true){
            if(isBalanced(num)){
                return num;
            }
            num++;
        }
    }
}