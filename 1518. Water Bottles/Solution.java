class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        int buy = numBottles / numExchange;
        int remains = numBottles % numExchange;
        ans += buy;

        while (buy + remains >= numExchange) {
            int temp = (buy + remains) / numExchange;
            remains = (buy + remains) % numExchange;
            buy = temp;
            ans += buy;

        }

        return ans;
    }
}