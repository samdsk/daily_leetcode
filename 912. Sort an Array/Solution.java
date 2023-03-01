class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1,new int[nums.length]);
        return nums;
    }

    public void mergeSort(int[] nums, int i,int f,int[] tempArr){
        if(i>=f) return;

        int mid = (f+i)/2;

        mergeSort(nums,i,mid,tempArr);
        mergeSort(nums,mid+1,f,tempArr);

        merge(nums,i,f,mid,tempArr);

    }

    public void merge(int[] nums, int s, int f, int m,int[] tempArr){
        int l1 = m-s+1;
        for(int i = 0;i<l1;i++){
            tempArr[s+i] = nums[s+i];
        }
        int l2 = f-m;
        for(int i = 0;i<l2;i++){
            tempArr[m+i+1] = nums[m+i+1];
        }

        int i = 0, j = 0, k = s;
        while(i<l1 && j<l2){
            if(tempArr[s+i] <= tempArr[m+j+1]){
                nums[k] = tempArr[s+i];
                i++;
            }else{
                nums[k] = tempArr[m+j+1];
                j++;
            }

            k++;
        }

        while(i<l1){
            nums[k] = tempArr[s+i];
            i++;
            k++;
        }

        while(j<l2){
            nums[k] = tempArr[m+j+1];
            j++;
            k++;
        }
    }
}