class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow = nums[0]
        fast = nums[0]
        
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
            
        index = nums[0]
        
        while slow != index:
            slow = nums[slow]
            index = nums[index]
            
        return index