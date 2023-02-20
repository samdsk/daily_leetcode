/**
 * Solution
 */
public class Solution {

    public int maxProfit(int[] prices){
        if(prices.length<0 || prices.length==1){
            return 0;
        }

        int profit = 0;
        int min = prices[0];

        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }            
            profit = Math.max(profit, prices[i]-min);
        }

        return profit;       
        
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));//5
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new Solution().maxProfit(new int[]{2,4,1}));//2
        System.out.println(new Solution().maxProfit(new int[]{2,1,2,1,0,1,2}));//
        System.out.println(new Solution().maxProfit(new int[]{1,2}));//1

    }
}