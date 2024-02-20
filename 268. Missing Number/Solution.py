class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)+1
        ans = 0
        for i in range(n):
            ans ^= i

        for i in nums:
            ans ^= i

        return ans