class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        if k < 1 : return 0
        ans = right = left = 0
        freq = defaultdict(int)

        while right < len(nums):
            key = nums[right]
            freq[key] += 1

            while left <= right and freq[key] > k:
                freq[nums[left]] -= 1
                left += 1

            ans = max(ans, right - left + 1)
            right += 1

        return ans