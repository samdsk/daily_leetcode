import java.util.HashSet;
import java.util.Set;

class Solution {
    // public int longestPalindrome(String s) {
    //     if(s.length() == 1) return 1;

    //     Set<Character> set = new HashSet<>();
    //     int count = 0;
    //     for(char c : s.toCharArray()){
    //         if(set.contains(c)){
    //             set.remove(c);
    //             count++;
    //         }else{
    //             set.add(c);
    //         }
    //     }

    //     if(set.isEmpty()) return count * 2;
    //     return count * 2 + 1;
    // }

    public int longestPalindrome(String s){
        int[] arr = new int[128];
        for(char c : s.toCharArray()){
            arr[c]++;
        }

        int count = 0;

        for(int n : arr){
            count += n / 2 * 2;
        }

        return count < s.length() ? count+1 : count;
    }
}