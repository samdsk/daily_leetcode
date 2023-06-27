import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();

        Set<Pair<Integer,Integer>> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[0]-b[0]));

        minHeap.offer(new int[]{nums1[0]+nums2[0],0,0});

        visited.add(new Pair<Integer,Integer>(0,0));

        while(k-- > 0 && !minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            ans.add(List.of(nums1[i],nums2[j]));
            Pair<Integer,Integer> temp = new Pair<>(i+1, j);

            if(i+1 < m && !visited.contains(temp)){
                minHeap.offer(new int[]{nums1[i+1]+nums2[j],i+1,j});
                visited.add(temp);
            }

            temp = new Pair<>(i, j+1);

            if(j+1 < n && !visited.contains(temp)){
                minHeap.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
                visited.add(temp);
            }
        }

        return ans;
    }

    private class Pair<T1, T2> {
        public T1 a;
        public T2 b;

        public Pair(T1 i, T2 j) {
            a = i;
            b = j;
        }

    }
}