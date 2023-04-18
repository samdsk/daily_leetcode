class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        index = -1
        _min = math.inf
        i = 0
        for point in points:

            if(x == point[0] or y == point[1]):
                d =  abs(x - point[0]) + abs(y - point[1])
                if d < _min:
                    _min = d
                    index = i

            i += 1

        return index