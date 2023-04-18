class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        valid = [p for p in points if p[0] == x or p[1] == y]

        if(len(valid)>0):
            _min = min(valid,key = lambda p: abs(x-p[0])+abs(y-p[1]))
            return points.index(_min)
        else:
            return -1