import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    private class Pair<T1, T2> {
        T1 key;
        T2 value;

        public Pair(T1 A,T2 B){
            this.key = A;
            this.value = B;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,List<Pair<Integer,Double>>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            double prob = succProb[i];

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair<>(b,prob));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair<>(a,prob));
        }

        double[]  maxProb = new double[n];

        PriorityQueue<Pair<Double,Integer>> pq = new PriorityQueue<>((a,b) -> -Double.compare(a.key, b.key));

        pq.offer(new Pair<>(1.0,start));

        while(!pq.isEmpty()){
            Pair<Double,Integer> current = pq.poll();

            double prob = current.key;
            int node = current.value;

            if(node == end) return prob;

            for(Pair<Integer,Double> NEXT : graph.getOrDefault(node, new ArrayList<>())){
                int nextNode = NEXT.key;
                double nextProb = NEXT.value;

                if(prob * nextProb > maxProb[nextNode]){
                    maxProb[nextNode] = prob * nextProb;
                    pq.add(new Pair<Double,Integer>(maxProb[nextNode],nextNode));
                }
            }
        }

        return 0.;
    }


}