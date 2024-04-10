class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length; 
        int[] ans = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            queue.offer(i);
        }
        int index = 0;
        while(!queue.isEmpty() && index<n){
            ans[queue.poll()] = deck[index++];
            queue.offer(queue.poll());
        }
        
        return ans;
    }
}