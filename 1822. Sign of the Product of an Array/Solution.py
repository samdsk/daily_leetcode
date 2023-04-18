class Solution:
    def arraySign(self, nums: List[int]) -> int:
        negs = 0

        for n in nums:
            if n == 0 : return 0
            if n < 0 : negs += 1


        return 1 if negs % 2 == 0 else -1
