class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] list = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            list[i] = arr[i];
        }

        Arrays.sort(list, (a,b)->{
            int counta = Integer.bitCount(a);
            int countb = Integer.bitCount(b);

            if(counta == countb){
                return a.compareTo(b);
            }

            return Integer.compare(counta, countb);
        });

        for(int i = 0; i < arr.length; i++){
            arr[i] = list[i];
        }
        return arr;
    }
}