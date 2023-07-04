class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int n : nums){
            ans ^= n;
        }

        return ans;
    }
}

/*
Bit manipulation with XOR operator

0101 XOR 0000 = 0101
0101 XOR 0101 = 0000

order of operations doesnt matter if we find
the same number again it will cancel it out
and in the end will remain the "odd" number
 */