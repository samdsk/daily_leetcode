class Solution {
    public String mergeAlternately(String word1, String word2) {
        int min = Math.min(word1.length(),word2.length());

        int i = 0;
        StringBuilder ans = new StringBuilder();

        while(i<min){
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
            i++;
        }

        if(i<word1.length()){
            ans.append(word1.toCharArray(),i,word1.length()-i);
        }else{
            ans.append(word2.toCharArray(),i,word2.length()-i);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mergeAlternately("abc", "pqr"));
    }
}