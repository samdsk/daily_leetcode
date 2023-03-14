import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // private int sum;

    // public int sumNumbers(TreeNode root) {
    //     if(root == null) return 0;
    //     this.sum = 0;

    //     helper(new StringBuilder(), root);

    //     return sum;
    // }

    // private void helper(StringBuilder number, TreeNode root){
    //     if(root == null) {
    //         return;
    //     }        
    //     StringBuilder temp = new StringBuilder(number);
    //     temp.append(root.val);

    //     if(root.left == null && root.right == null){
    //         sum += Integer.parseInt(temp.toString());
    //         return;
    //     }

    //     helper(temp, root.left);
    //     helper(temp, root.right);


    //     return;

    // }

    private int sum;

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        helper(0, root);

        return sum;
    }

    private void helper(int number, TreeNode root){
        if(root == null) {
            return;
        }        
        number = number * 10 + root.val;

        if(root.left == null && root.right == null){
            sum += number;
            return;
        }

        helper(number, root.left);
        helper(number, root.right);


        return;

    }
}