class Solution {
    public int maxPathSum(TreeNode root) {
        int [] res = new int[]{root.val};
        findMax(root,res);
        return res[0];
    }

    public int findMax(TreeNode root, int [] res){
        if(root == null){
            return 0;
        }

        int maxLeft = Math.max(findMax(root.left,res),0);
        int maxRight = Math.max(findMax(root.right,res),0);

        res[0] = Math.max(maxLeft+maxRight+root.val, res[0]);

        return root.val + Math.max(maxLeft, maxRight);
    }
}
