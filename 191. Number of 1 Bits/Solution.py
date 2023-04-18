class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        for i in range(32):
            count += (n & 1)
            n >>= 1

        return count