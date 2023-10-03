class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        counts = [0 for i in range(101)]
        K = 2

        for i in range(len(nums)):
            counts[nums[i]] += 1

        ans = 0

        for i in range(0,101):
            N = counts[i]
            ans += (N * (N-1))//K

        return ans