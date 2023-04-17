class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        _max = max(candies) - extraCandies
        ans = []
        for candie in candies:
            ans.append(candie >= _max)

        return ans