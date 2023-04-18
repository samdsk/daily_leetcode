import math

class Solution:
    def average(self, salary: List[int]) -> float:
        salary.remove(min(salary))
        salary.remove(man(salary))

        return sum(salary)/len(salary)