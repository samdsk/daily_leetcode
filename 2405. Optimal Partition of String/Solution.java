import java.util.Arrays;

class Solution {
    public int partitionString(String s) {
        int[] chars = new int[26];
        Arrays.fill(chars,-1);
        int count = 1, sub = 0;

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            if(chars[temp] >= sub){
                count++;
                sub = i;
            }
            chars[temp] = i;
        }

        return count;
    }

    // solution with bit manipulation
    public int partitionStringBit(String s) {
        int ans = 1;
        int mask = 0;

        for (char c : s.toCharArray()) {
            int shift = c - 'a';
            if ((mask & (1 << shift)) > 0) {
                ans++;
                mask = 0;
            }
            mask |= 1 << shift;
        }
        return ans;
    }
}