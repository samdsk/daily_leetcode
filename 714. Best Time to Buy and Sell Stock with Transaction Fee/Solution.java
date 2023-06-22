class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int free = 0;
        int hold = -prices[0];

        for (int i = 1; i < n; i++) {
            int temp = hold;
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, temp + prices[i] - fee);
        }

        return free;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}