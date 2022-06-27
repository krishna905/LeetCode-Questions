/*
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.



Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
*/




class Solution {
    
    int count=0;
    
	// calculate path for each node as root
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        
        calculatePath(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        
        return count;
        
    }
    
	// identify how many path can be possible if we take this node as root
    public void calculatePath(TreeNode node, int targetSum){
        
        if(node==null){
            return ;
        }
        
        if(targetSum==node.val){
            count++;
        }
 
        targetSum=targetSum-node.val;
        calculatePath(node.left, targetSum);
        calculatePath(node.right, targetSum);
    }
    
}
