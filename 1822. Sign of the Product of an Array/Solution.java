class Solution {
    public int arraySign(int[] nums) {
        int negs = 0;

        for(int n : nums){
            if(n == 0) return 0;
            if(n<0) negs++;
        }

        return negs % 2 == 0 ? 1 : -1;
    }
}