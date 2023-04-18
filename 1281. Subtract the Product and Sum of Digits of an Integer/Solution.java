class Solution {
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;

        while(n > 0){
            int temp = n % 10;
            prod *= temp;
            sum += temp;
            n /= 10;
        }

        return prod - sum;
    }
}