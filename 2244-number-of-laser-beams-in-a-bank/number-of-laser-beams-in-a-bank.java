class Solution {
    public int CountDevice(String row){
        int count = 0;
        for(int i = 0; i < row.length(); i++){
            if(row.charAt(i) == '1') count++;
        }
        return count;
    }

    private int solve(String[] bank, int rowIndex, int PDeviceCount){
        if(rowIndex == bank.length) return 0;

        int CDeviceCount = CountDevice(bank[rowIndex]);
        if(CDeviceCount > 0){
            int beam = PDeviceCount * CDeviceCount;
            return beam + solve(bank, rowIndex + 1, CDeviceCount);
        }
        else{
            return solve(bank, rowIndex + 1, PDeviceCount);
        }
    }
    public int numberOfBeams(String[] bank) {
        // int totalBeam = 0;
        // int PDeviceCount = 0;

        // for(String r : bank){
        //     int CDeviceCount = 0;
        //     for(int i = 0; i < r.length(); i++){
        //         if(r.charAt(i) == '1') CDeviceCount++;
        //     }

        //     if(CDeviceCount > 0){
        //         totalBeam = totalBeam + PDeviceCount * CDeviceCount;
        //         PDeviceCount = CDeviceCount;
        //     }
        // }
        // return totalBeam;

        return solve(bank, 0, 0);
    }
}