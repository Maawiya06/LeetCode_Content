class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        List<Integer> minuteList = new ArrayList<>();

        // string to integer conversion
        for(String s : timePoints){
            int hour = Integer.parseInt(s.substring(0, 2));
            int minute = Integer.parseInt(s.substring(3, 5));
            minuteList.add(hour * 60 + minute);
        }

        // sortuing
        Collections.sort(minuteList);

        // conpair diffrece
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < minuteList.size(); i++){
            minDiff = Math.min(minDiff, minuteList.get(i) - minuteList.get(i - 1));
        }

        // circular diff
        int circularDiff = (minuteList.get(0) + 1440) - minuteList.get(minuteList.size() - 1);
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;

    }
}