class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int n = colors.length();
        char[] arr = colors.toCharArray();

        for (int i = 1; i < n; i++) {
            int prev = neededTime[i-1];
            int sum = prev;
            int max = prev;

            while(i < n && arr[i-1] == arr[i]){
                sum += neededTime[i];
                max = Math.max(neededTime[i], max);
                i++;
            }

            ans += sum-max;
        }

        return ans;
    }
} 