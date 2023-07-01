class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];
        return dfs(0,distribute,cookies,k,k);
    }

    private int dfs(int i, int[] distribute, int[] cookies, int k, int zeroCount) {
        if(cookies.length - i < zeroCount) return Integer.MAX_VALUE;

        if(i == cookies.length){
            int unfairness = Integer.MIN_VALUE;
            for(int value : distribute){
                unfairness = Math.max(value, unfairness);
            }
            return unfairness;
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            zeroCount -= distribute[j] == 0 ? 1 : 0;
            distribute[j] += cookies[i];
            ans = Math.min(ans, dfs(i+1, distribute, cookies, k, zeroCount));

            distribute[j] -= cookies[i];
            zeroCount += distribute[j] == 0 ? 1 : 0;
        }

        return ans;
    }
}