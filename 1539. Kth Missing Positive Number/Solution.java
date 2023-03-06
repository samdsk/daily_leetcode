class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int count = 0;
        int missing = 0;

        while(i<arr.length){
            missing++;
            if(arr[i]==missing){
                i++;
            }else{
                count++;
            }
            
            if(count==k) return missing;
        
        }       

        while(count<k){
            count++;
            missing++;
        }

        return missing;

    }

    public static void main(String[] args) {
        //System.out.println(new Solution().findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println(new Solution().findKthPositive(new int[]{1,2,3,4}, 2));
    }
}