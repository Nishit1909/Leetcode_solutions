
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode node=method(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return node;
    }
    public TreeNode method(int []postorder,int post,int postend,int []inorder,int inst,int inend,Map<Integer,Integer> map){
        if(inst>inend || post>postend) return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int inroot=map.get(root.val);
        int numsleft=inroot-inst;
        root.left=method(postorder,post,post+numsleft-1,inorder,inst,inroot-1,map);
        root.right=method(postorder,post+numsleft,postend-1,inorder,inroot+1,inend,map);
        return root;
    }
}