import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // Queue<Integer> q = new LinkedList<>();

        // for(int n : nums)
        //     q.add(n);

        // List<List<Integer>> ans = new ArrayList<>();

        // while(!q.isEmpty()){
        //     int size = q.size();

        //     Set<Integer> temp = new HashSet<>();

        //     while(!q.isEmpty() && size>=0){    
        //         Integer n = q.poll();

        //         if(!temp.add(n)){
        //             q.add(n);
        //         }
        //         size--;
        //     }

        //     List<Integer> l = new ArrayList<>();
        //     l.addAll(temp);

        //     ans.add(l);
        // }

        int[] freqs = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();

        for(int n : nums){
            if(freqs[n] >= ans.size())
                ans.add(new ArrayList<>());

            ans.get(freqs[n]).add(n);
            freqs[n]++;
        }

        return ans;
    }
}