import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if(nums2[j]>nums1[i]){
                    nums1[i] = nums2[j];
                    break;
                }else if(j == nums2.length-1){
                    nums1[i] = -1;
                }

            }
        }

        return nums1;
    }
}