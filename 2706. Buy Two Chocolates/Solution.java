class Solution {
    public int buyChoco(int[] prices, int money) {
        int cheapest = prices[0];
        int second_cheapest = prices[1];

        for(int i=1;i<prices.length;i++){
            if(cheapest > prices[i]){
                second_cheapest = cheapest;
                cheapest = prices[i];
            }else if(second_cheapest > prices[i]){
                second_cheapest = prices[i];
            }
        }

        // System.out.println(cheapest+" - "+second_cheapest);

        int sum = cheapest + second_cheapest;

        if( sum <= money) return money - sum;
        return money;
    }
}