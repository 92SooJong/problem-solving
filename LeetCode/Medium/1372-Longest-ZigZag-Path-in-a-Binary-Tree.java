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
    
    public static int recursive(TreeNode curNode,boolean isNextRight,int zigZagCount){
        
        if(curNode == null){
          return zigZagCount-1;
        } 
        else{

            int right = 0;
            int left = 0;
            // move to right
            if(isNextRight){
                right = recursive(curNode.right,false,zigZagCount+1);    
                left = recursive(curNode.left,true,1); //can't move same direction in a row so restart
            }
            
            // move to left
            if(!isNextRight){
                left = recursive(curNode.left,true,zigZagCount+1);
                right = recursive(curNode.right,false,1); //can't move same direction in a row so restart
            }
            
            return Math.max(right,left);
        }

    }
    
    public int longestZigZag(TreeNode root) {
        
        int right = recursive(root,true,0);
        int left = recursive(root,false,0);
        return Math.max(right,left);
    }
}
