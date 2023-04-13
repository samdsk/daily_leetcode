import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length) return false;

        int i = 0;
        int j = 0;

        for(int x : pushed){
            pushed[i++] = x;
            while(i>0 && pushed[i-1] == popped[j]){
                i--;
                j++;
            }
        }

        return i==0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }
}