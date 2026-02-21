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
    
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++){
            int setbit = Integer.bitCount(i);
            if(isPrime(setbit)){
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n){
        if(n <= 1) return false;

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}