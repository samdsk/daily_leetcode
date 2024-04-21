class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(Map<Integer,List<Integer>> graph, int source, int destination, Set<Integer> visited){
        if(source == destination) return true;

        visited.add(source);
        for(int n : graph.get(source)){
            if(!visited.contains(n)){
                if(dfs(graph, n, destination, visited)) 
                    return true;
            }
        }

        return false;
    }
}