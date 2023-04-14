class Solution {
    public int longestPalindromeSubseq(String s) {
        // int n = s.length();
        // int[] dp = new int[n];
        // int[] dpPrev = new int[n];

        return find(0, s.length()-1, s);
    }

    private int find(int i, int j, String s){
        if(i>j) return 0;
        if(i==j) return 1;

        if(s.charAt(i) == s.charAt(j)) return 2+find(++i,--j,s);
        else return Math.max(find(i+1,j,s),find(i,j-1, s));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindromeSubseq("bbbab"));
        System.out.println(new Solution().longestPalindromeSubseq("cbbd"));
    }
}