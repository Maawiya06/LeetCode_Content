class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n - 1;

        while(s < e){
            int mid = s + (e - s) / 2;

            if(arr[mid] < arr[mid + 1]){
                s = mid + 1;
            }
            else{
                e = mid;
            }
        }

        return s;
    }
}