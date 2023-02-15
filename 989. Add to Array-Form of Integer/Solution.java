import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length-1;
        List<Integer> l = new ArrayList<>();
        int overflow = 0;
        while(k>0 || i>=0){
            int temp = 0;
            
            if(i>=0){
                temp = num[i]+overflow;
                i--;
            }else temp += overflow;

            if(k>0){
                temp += k % 10;
                k /= 10;
            }

            if(temp>9) overflow = 1;
            else overflow = 0;

            l.add(temp%10);
        }
        if(overflow==1) l.add(1);
        Collections.reverse(l);
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6};
        int k = 809;

        List<Integer> l = new Solution().addToArrayForm(nums,k);
        System.out.println(l);
    }
}

