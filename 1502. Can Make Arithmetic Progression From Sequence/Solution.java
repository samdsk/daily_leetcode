class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for(int n : arr){
            if(min>n) min = n;
            if(max<n) max = n;
        }

        int n = arr.length;

        if((max - min) % (n-1) != 0) return false;

        int diff = (max - min) / (n-1);
        int i = 0;

        while(i<n){
            if(arr[i] == min + i * diff) i++;
            else if((arr[i] - min ) % diff != 0) return false;
            else{
                int j = (arr[i] - min) / diff;

                if(arr[i] == arr[j]) return false;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return true;
    }
}