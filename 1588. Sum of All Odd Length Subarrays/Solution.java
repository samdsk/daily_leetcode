class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp += arr[j];
                if((j-i+1) % 2 != 0) sum += temp;
            }
        }

        return sum;
    }
}