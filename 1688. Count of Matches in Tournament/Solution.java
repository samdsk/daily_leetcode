class Solution {
    public int numberOfMatches(int n) {
        return nextMatch(n,0);
    }

    private int nextMatch(int n, int tot){
        if(n < 2) return tot;
        int res = n/2;
        if(n%2 != 0) return nextMatch(res + 1, tot + res);
        else return nextMatch(res, tot + res);        
    }
}