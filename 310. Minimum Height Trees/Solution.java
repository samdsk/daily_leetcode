class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        Map<Integer,Integer> neighbours = new HashMap<>();
        Queue<Integer> leaves = new LinkedList<>();
        
        for(int node : graph.keySet()){
            int size = graph.get(node).size();
            if(size == 1)
                leaves.add(node);
            neighbours.put(node, size);
        }

        while(n > 2 && !leaves.isEmpty()){
            int size = leaves.size();

            for(int i=0;i<size;i++){
                int node = leaves.poll();
                n--;
                for(int nei : graph.get(node)){
                    neighbours.put(nei, neighbours.get(nei) - 1);
                    if(neighbours.get(nei) == 1)
                        leaves.add(nei);
                }
            }
        }

        return (List)leaves;
    }

   
}