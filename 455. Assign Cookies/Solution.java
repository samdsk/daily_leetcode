class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int m = g.length, n = s.length;

        int count = 0;

        while(i<m && j<n){
            if(g[i] <= s[j]){
                i++;
                count++;
            }
            j++;            
        }

        return count;
    }
}