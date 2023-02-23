import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Official solution
 */
public class Solution {
    private class Project implements Comparable<Project>{
        protected int capital;
        protected int profit;

        public Project(int c,int p){
            this.capital = c;
            this.profit = p;
        }

        @Override
        public int compareTo(Solution.Project p) {
            return capital - p.capital;
        }

    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];

        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        Arrays.sort(projects);

        PriorityQueue<Integer> queue = new PriorityQueue<>(n,Collections.reverseOrder());
        int current = 0;
        for (int i = 0; i < k; i++) {
            while(current<n && projects[current].capital <= w ){
                queue.add(projects[current++].profit);
            }
            if(queue.isEmpty()) break;
            w += queue.poll();
        }

        return w;

    }
    
}