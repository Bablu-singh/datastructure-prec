class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        
        int i = 0;

        while(inorder[i]!=root.val){
            i++;
        }
        int mid = i;
        int [] leftPre = Arrays.copyOfRange(preorder,1,mid+1);
        int [] leftIn = Arrays.copyOfRange(inorder,0,mid);

        root.left = buildTree(leftPre,leftIn);

        int [] rightPre = Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int [] rightIn = Arrays.copyOfRange(inorder,mid+1,inorder.length);

        root.right = buildTree(rightPre,rightIn);
        return root;
    }
}
