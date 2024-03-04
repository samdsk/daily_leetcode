class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0, right = tokens.length-1;
        int score = 0;
        int max = 0;
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left];
                score++;
                left++;
                max = Math.max(max,score);
            }else if(score > 0){
                power += tokens[right];
                score--;
                right--;
            }else{
                break;
            }
        }

        return max;
    }
}