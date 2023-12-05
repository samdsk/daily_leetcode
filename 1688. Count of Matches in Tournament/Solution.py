class Solution:
    def nextMatch(self,n : int,total : int) -> int: 
        if n < 2 :
            return total
        
        res = n//2
        
        if n % 2 != 0:
            return self.nextMatch(res+1,total+res)
        else:
            return self.nextMatch(res,total+res)
        
    def numberOfMatches(self, n: int) -> int:
        return self.nextMatch(n,0)