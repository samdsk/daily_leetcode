class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max = 0;
        int[] freq = new int[101];

        for(int n : nums){
            freq[n]++;
            max = Math.max(max, freq[n]);
        }

        int count = 0;
        for(int n : freq){
            if(n == max)
                count += n;
        }

        return count; 
    }
}