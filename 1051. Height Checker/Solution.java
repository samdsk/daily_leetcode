class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = new int[n];

        for(int i=0;i<n;i++){
            expected[i] = heights[i];
        }

        quickSort(expected, 0 , n-1);

        int count = 0;
        for(int i=0;i<n;i++){
            if(expected[i] != heights[i]) count++;
        }


        return  count;
    }

    private void quickSort(int[] arr, int left, int right){
        if(left < right){
            int p = partition(arr, left, right);
            quickSort(arr,left, p-1);
            quickSort(arr,p+1, right);
        }
        
    }

    private int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int small = left;

        for(int i=left; i < right;i++){
            if(arr[i] <= pivot){
                int temp = arr[small];
                arr[small] = arr[i];
                arr[i] = temp;
                small++;
            }
        }

        int temp = arr[small];
        arr[small] = arr[right];
        arr[right] = temp;

        return small;
    }
}