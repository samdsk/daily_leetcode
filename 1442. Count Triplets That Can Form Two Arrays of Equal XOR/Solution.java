class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        // 2,3,1,6,7

        int count = 0;

        // 2 -> 010
        // 3 -> 011 
        // 1 -> 001 
        // 6 -> 110
        // 7 -> 111

        for(int i=0;i<n-1;i++){
            int a = 0;
            for(int j=i+1;j<n;j++){
                int b = 0;
                a ^= arr[j-1];
                for(int k=j;k<n;k++){
                    b ^= arr[k];

                    if(a == b) count++;
                }
            }
        }

        return count;
    }
}