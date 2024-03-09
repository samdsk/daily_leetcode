class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;

        if(nums1[0] > nums2[n-1] || nums1[m-1] < nums2[0])
            return -1;

        while(i<m && j<n){
            if(nums1[i] == nums2[j]) 
                return nums1[i];
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
            
        }

        return -1;
    }
}