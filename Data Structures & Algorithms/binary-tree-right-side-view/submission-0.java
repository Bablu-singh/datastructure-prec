class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> q  = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode rightSide = null;
            int n = q.size();
            for(int i= 0 ;i<n;i++){
                TreeNode node = q.poll();

                if(node!=null){
                    rightSide = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(rightSide!=null){
                list.add(rightSide.val);
            }

        }
        return list;
    }
}
