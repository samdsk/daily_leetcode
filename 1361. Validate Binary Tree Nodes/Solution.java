import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);

        if(root == -1) return false;

        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        seen.add(root);
        stack.push(root);

        while(!stack.isEmpty()){
            int node = stack.pop();
            int[] childrenOfNode = {leftChild[node],rightChild[node]};

            for (int child : childrenOfNode) {
                if(child != -1){
                    if(!seen.add(child)){
                        return false;
                    }

                    stack.push(child);
                }
            }
        }

        return seen.size() == n;
    }

    private int findRoot(int n, int[] leftChild, int[] rightChild){
        Set<Integer> set = new HashSet<>();

        for(int node : leftChild)
            set.add(node);

        for (int node : rightChild) 
            set.add(node);

        for (int i = 0; i < n; i++) {
            if(!set.contains(i)) return i;
        }

        return -1;        
    }
}