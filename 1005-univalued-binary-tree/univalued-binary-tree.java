class Solution {
    public boolean helper(TreeNode root , int val){
        if(root == null){
            return true ;
        }

        if(root.val != val){
            return false ;
        }

        boolean leftans = helper(root.left,val);
        boolean rightans = helper(root.right,val);
        return leftans && rightans;
    }
    public boolean isUnivalTree(TreeNode root) {
        return helper(root,root.val);
    }
}