class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        int n = tickets.length;
            for(int i=0;i<n;i++){
                if(i<=k){
                    count += Math.min(tickets[k], tickets[i]);
                }else{
                    count += Math.min(tickets[k]-1, tickets[i]);
                }
            }

        return count;
    }
}