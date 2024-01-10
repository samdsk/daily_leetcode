/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        binaryTreeToGraph(root, 0, graph);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int minutes = 0;

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size>0){
                int curr = queue.poll();
                for(int n : graph.get(curr)){
                    if(!visited.contains(n)){
                        visited.add(n);
                        queue.add(n);
                    }
                }
                size--;
            }
            minutes++;
        }
        return minutes-1;
    }

    private void binaryTreeToGraph(TreeNode root, int parent, Map<Integer,Set<Integer>> graph){
        if(root == null) return;

        if(!graph.containsKey(root.val))
            graph.put(root.val, new HashSet<>());

        Set<Integer> neighbours = graph.get(root.val);

        if(parent != 0)
            neighbours.add(parent);

        if(root.left != null)
            neighbours.add(root.left.val);
        if(root.right != null)
            neighbours.add(root.right.val);
        
        binaryTreeToGraph(root.left,root.val,graph);
        binaryTreeToGraph(root.right,root.val,graph);
    }
}