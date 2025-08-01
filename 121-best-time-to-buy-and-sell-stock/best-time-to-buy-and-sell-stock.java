class Solution {
    public void helperfunction(int[] prices, int i, int minprice, int[] maxprofit){
        if(i == prices.length) return;

        if(prices[i] < minprice) minprice = prices[i];

        int todayprofit = prices[i] - minprice;

        if(todayprofit > maxprofit[0]) maxprofit[0] = todayprofit;

        helperfunction(prices, i + 1, minprice, maxprofit);
    }

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int[] maxprofit = new int[1];  
        helperfunction(prices, 0, minprice, maxprofit);
        return maxprofit[0];
    }
}
