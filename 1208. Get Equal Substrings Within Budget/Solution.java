class Solution {
    private int max_len = 0;

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int total_cost = 0;

        while(right < n){

            total_cost += Math.abs((int) s.charAt(right) - t.charAt(right));

            while(total_cost > maxCost && left < n){
                total_cost -= Math.abs((int) s.charAt(left) - t.charAt(left));
                left++;
            }

            max_len = Math.max(max_len, right - left + 1);
            right++;
        }

        return max_len;
    }
}