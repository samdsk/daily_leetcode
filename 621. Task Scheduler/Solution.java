class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        int max = 0;
        int count = 0;

        for(char task : tasks){
            freq[task - 'A']++;
            int curFreq = freq[task - 'A'];

            if(max == curFreq)
                count++;
            else if(max < curFreq){
                max = curFreq;
                count = 1;
            }
        }

        int parts = max - 1;
        int partSize = n - (count - 1);
        int emptySlots = parts * partSize;
        int availableTasks = tasks.length - max * count;
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }
}