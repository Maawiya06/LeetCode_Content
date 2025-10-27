class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeam = 0;
        int PDeviceCount = 0;

        for(String r : bank){
            int CDeviceCount = 0;
            for(int i = 0; i < r.length(); i++){
                if(r.charAt(i) == '1') CDeviceCount++;
            }

            if(CDeviceCount > 0){
                totalBeam = totalBeam + PDeviceCount * CDeviceCount;
                PDeviceCount = CDeviceCount;
            }
        }
        return totalBeam;
    }
}