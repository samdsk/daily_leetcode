import math

class Solution:
    def average(self, salary: List[int]) -> float:
        _min = math.inf
        _max = -math.inf
        _sum = 0.0

        for s in salary:
            _min = min(s,_min)
            _max = max(s,_max)
            _sum += s

        return (_sum - _min - _max) / (len(salary) -2)