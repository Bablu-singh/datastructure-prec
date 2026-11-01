class Solution {
    public int goodNodes(TreeNode root) {
        int t[] = new int[3];

        return checkGoodNodes(root, root.val);
    }

    private int checkGoodNodes(TreeNode root, int max) {

        if (root == null) {
            return 0;
        }
        int good = 0 ;
        if(root.val >= max){
            good =1 ;
        }
        max = Math.max(max,root.val);
        good+=checkGoodNodes(root.right,max);
        good+=checkGoodNodes(root.left,max);
        return good;
    }
}
