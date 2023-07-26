class Solution {
    public double myPow(double x, int n) {
        return binaryPow(x,(long) n);
    }

    private double binaryPow(double x, long n){
        if(n == 0) return 1.;
        
        if(n<0){
            n = -1*n;
            x = 1. / x;
        }

        double ans = 1.;

        while(n!=0){
            if(n%2==1){
                ans *= x;
                n--;
            }

            x = x * x;
            n /= 2;
        }
        return ans;
    }
}