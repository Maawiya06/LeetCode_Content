class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        // sorting
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // adding 1st interval
        int[] current = intervals[0];
        merged.add(current);

        // iterate to all
        for(int[] interval : intervals){
            int currStart = current[0];
            int currEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];


            // condition for overlapping
            if(nextStart <= currEnd){
                current[1] = Math.max(currEnd, nextEnd);
            }
            else{
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}