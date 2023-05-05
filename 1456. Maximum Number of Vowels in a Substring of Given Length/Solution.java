class Solution {
    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < k; i++) {
            if(isVowel(arr[i])) count++;
        }

        int ans = count;

        if(ans == k) return k;

        for(int i = k;i < s.length(); i++){
            if(isVowel(arr[i])) count++;
            if(isVowel(arr[i-k])) count--;
            ans = Math.max(ans,count);
        }

        return ans;
    }

    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ;
    }
}