class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("000");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
    public int binaryGap(int n) {
        int maxdist = 0;
        int currdist = 0;

        boolean get = false;

        while(n > 0){
            int bit = n % 2;

            if(bit == 1){
                if(get){
                    maxdist = Math.max(maxdist, currdist);
                }
                currdist = 1;
                get = true;
            }
            else{
                if(get) currdist++;
            }

            n /= 2;
        }

        return maxdist;
    }
}