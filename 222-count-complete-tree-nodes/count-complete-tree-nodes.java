class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0 ;
        }
        int leftAns = countNodes(root.left);
        int rightAns = countNodes(root.right);
        return leftAns + rightAns + 1 ;
    }
}