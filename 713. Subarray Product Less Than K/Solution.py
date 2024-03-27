class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1 : return 0

        left = right = count = 0
        prod = 1

        while right < len(nums):
            prod *= nums[right]

            while left <= right and prod >= k:
                prod //= nums[left]
                left += 1

            count += right - left + 1
            right += 1

        return count