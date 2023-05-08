import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[n];
        queue.offer(start);

        while(!queue.isEmpty()){
            int index = queue.poll();

            if(visited[index]) continue;
            visited[index] = true;

            if(arr[index] == 0) return true;


            int temp = index + arr[index];
            if(temp >= 0 && temp < n) queue.offer(temp);

            temp = index - arr[index];
            if(temp >= 0 && temp < n) queue.offer(temp);

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canReach(new int[]{4,2,3,0,3,1,2}, 5));
    }
}