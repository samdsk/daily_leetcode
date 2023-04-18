class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        prod = 1
        sum = 0

        while n>0:
            temp = n % 10
            prod *= temp
            sum += temp
            n //= 10

        return prod - sum