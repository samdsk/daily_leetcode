class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int highest = 0;
        int current = 0;

        for(int i=0;i<n;i++){
            current += gain[i];
            highest = Math.max(highest,current);
        }

        return highest;
    }
}