class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root , long left ,long right){

        if(root ==null){
            return true;
        }
        int nodeValue = root.val;


        if(!(nodeValue > left && nodeValue < right)){
            return false;
        }

        return isValid(root.left, left , nodeValue) && isValid(root.right,nodeValue,right);
    }
}
