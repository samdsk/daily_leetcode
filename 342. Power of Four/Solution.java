class Solution {
    public boolean isPowerOfFour(int n) {
        // solution without loops and recursion
        // n & (n-1) checks for  the power of 2
        // n =>   8 = 1000
        // n-1 => 7 = 0111
        // and ==     0000
        // to filter out numbers that are power of 2 from power of 4
        // like 8, 32, we check the modulo of n % 3 == 1
        // es. 16%3 = 1, 64%3 = 1
        if(n<0) return false;
        if((n & (n-1)) == 0){
            if(n%3==1) return true;
        }

        return false;

        // one line solution
        // return (n > 0) && ((n & (n-1)) == 0) && ((n & 0x55555555) != 0) 
        // 0x5 = 0101 
        //   8 = 1000
        //   & = 0000 == 0
        // 0x55 = 0101 0101
        //   16 = 0001 0000
        //    & = 0001 0000 != 0

    }
}