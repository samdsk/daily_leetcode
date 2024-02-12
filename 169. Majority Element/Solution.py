class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        majority = nums[0]
        count = 0

        for i in nums:
            if count == 0:
                count = 1
                majority = i
            elif majority != i:
                count -= 1
            else:
                count += 1
        return majority