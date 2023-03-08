class Solution {
    public int characterReplacement(String s, int k) {
        int left = 1;
        int right = s.length()+1;

        while(left+1<right){
            int mid = left + (right-left)/2;

            if(isValid(s,mid,k)){
                left = mid;
            }else{
                right = mid;
            }

        }

        return left;
    }

    private boolean isValid(String s,int m,int k){
        int max = 0;
        int start = 0;
        int[] charmap = new int[26];

        for(int i=0;i<s.length();i++){
            charmap[s.charAt(i)-'A']++;
            if(i+1 - start > m){
                charmap[s.charAt(start)-'A']--;
                start++;
            }


            max = Math.max(max,charmap[s.charAt(i)-'A']);
            if(m - max <= k){
                return true;
            }
        }

        return false;
 
   }


   public static void main(String[] args) {
    System.out.println(new Solution().characterReplacement("ABAB", 2));
   }
}