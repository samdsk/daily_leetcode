class Solution {
    public int[] sortByBits(int[] arr) {
       mergeSort(arr, 0, arr.length-1);
       return arr;
    }

    private void mergeSort(int[] arr,int i,int f){
        if(i>=f) return;
        int m = i + (f-i)/2;
        mergeSort(arr,i,m);
        mergeSort(arr,m+1,f);
        merge(arr,i,m,f);
    }

    private void merge(int[] arr, int i,int m,int f){
        int n1 = m - i + 1;
        int n2 = f - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int l = 0; l < n1; l++) {
            left[l] = arr[l+i];
        }

        for (int l = 0; l < n2; l++) {
            right[l] = arr[l+m+1];
        }

        int j = 0, k = 0,curr = i;

        while(j < n1 && k < n2){
            if(compare(left[j], right[k]) < 0) arr[curr++] = left[j++];
            else arr[curr++] = right[k++];
        }

        while(j<n1) arr[curr++] = left[j++];


        while(k<n2) arr[curr++] = right[k++];

    }

    private int compare(int x,int y){
        int diff = hammingWeight(x) - hammingWeight(y);
        if(diff != 0) return diff;
        return Integer.compare(x, y);
    }

    private int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count += (n & 1);
            n = n >>> 1;
        }

        return count;
    }
}