class Solution {

    // recursive solution
    // public int minDistance(String word1, String word2) {
    //     if(word1.equals(word2)) return 0;
    //     return minDis(word1.toCharArray(), word2.toCharArray(), word1.length(), word2.length());
    // }

    // public int minDis(char[] word1, char[] word2, int w1,int w2){
    //     if(w1==0) return w2;
    //     if(w2==0) return w1;
    //     if(word1[w1-1] == word2[w2-1]){
    //         return minDis(word1, word2, w1-1, w2-1);
    //     }else{
    //         int replace = minDis(word1, word2, w1-1, w2-1)+1;
    //         int insert = minDis(word1, word2, w1, w2-1)+1;
    //         int delete = minDis(word1, word2, w1-1, w2)+1;

    //         return Math.min(replace,Math.min(insert, delete));
    //     }
    // }

    // public static void main(String[] args) {
    //     System.out.println(new Solution().minDistance("b", ""));
    // }


    // dynamic programming solution
    Integer memo[][];
    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()+1][word2.length()+1];        
        return minDis(word1, word2, word1.length(), word2.length());
    }

    public int minDis(String word1, String word2, int w1,int w2){
        if(w1==0) return w2;
        if(w2==0) return w1;

        if(memo[w1][w2] != null){
            return memo[w1][w2];
        }

        int minDis = 0;

        if(word1.charAt(w1-1) == word2.charAt(w2-1)){
            minDis = minDis(word1, word2, w1-1, w2-1);
        }else{
            int replace = minDis(word1, word2, w1-1, w2-1);
            int insert = minDis(word1, word2, w1, w2-1);
            int delete = minDis(word1, word2, w1-1, w2);

            minDis = Math.min(replace,Math.min(insert, delete))+1;
        }

        memo[w1][w2] = minDis;
        return minDis;
    }
}