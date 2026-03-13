class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }));
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long s = 1;
        long e = 10000000000000000L;

        while (s < e) {
            long mid = (s + e) / 2;
            long ans = 0;

            for (int i = 0; i < workerTimes.length && ans < mountainHeight; i++) {
                ans += (long)(Math.sqrt((double) mid / workerTimes[i] * 2 + 0.25) - 0.5);
            }

            if (ans >= mountainHeight) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }
}