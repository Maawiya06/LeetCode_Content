class Solution {
    public void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        int left = 0;
        int right = words.length - 1;

        while(left < right){
            swap(words, left, right);
            left++;
            right--;
        }

        return String.join(" ", words);
    }
}