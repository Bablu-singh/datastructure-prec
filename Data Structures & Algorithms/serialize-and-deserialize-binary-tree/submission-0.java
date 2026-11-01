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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSer(root,res);
        return String.join(",",res);
    }

    private void dfsSer(TreeNode root, List<String> res){
        if(root == null){
            res.add("null");
            return;
        }

        res.add(String.valueOf(root.val));
        dfsSer(root.left,res);
        dfsSer(root.right,res);
    }
    private TreeNode dfsDeSer(String [] vals, int[] i){
        if(vals[i[0]].equals("null")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsDeSer(vals,i);
        node.right = dfsDeSer(vals,i);


        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] d = data.split(",");
        int i[] = {0};
        return dfsDeSer(d,i);
        
    }
}
