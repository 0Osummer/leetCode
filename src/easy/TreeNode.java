package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
	
	//树的深度
	public int maxDepth(TreeNode root) {
		 if(root == null) return 0;
		 else{
			 int depthLeft = maxDepth(root.left);
			 int depthRight = maxDepth(root.right);
			 return 1 + (depthLeft > depthRight ? depthLeft : depthRight);
		 }
	        
	 }
	
	//两个树是否相同
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q == null) return true;
		if(p != null && q != null && p.val == q.val){
			return isSameTree(p.left, q.left)&& isSameTree(p.right, q.right);
		}
		return false;
			
    }
	
	//反转树
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode a = new TreeNode(root.val);
		a.right = invertTree(root.left);
		a.left =invertTree(root.right);
        return a;
    }
	
	//二分搜索树的最小公共祖先（一个节点是自己的子孙）
	//二分搜索树 某个节点的值大于它的左子树的所有值，小于右子树的所有值
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q ==null) return null;
		else if(root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val)) return root;
		else if(root.val > p.val && root.val > q.val)  return lowestCommonAncestor(root.left, p, q);
		return lowestCommonAncestor(root.right, p, q);
    }
	
	/**
	 * Given a binary tree, determine if it is height-balanced.
	 * the depth of the two subtrees of every node never differ by more than 1. 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right)) > 1) return false;
        else return isBalanced(root.left)&& isBalanced(root.right); 
    }
	
	/**
	 * 树是否是镜像对称的
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		//先反转树，然后比较反转后的树和原来的树是否为一样的
        if(root == null) return true;
        TreeNode other = invertTree(root);
        return isSameTree(root, other);
    }
	
	/**
	 * 层级遍历二叉树
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if(root == null) return result;
        list.add(root);
        int i = 1;
        int j = 0;
        while(!list.isEmpty()){
        	List<Integer> x = new ArrayList<>();
        	int nums_level = 0;
        	for(j=0;j<i;j++){
        		TreeNode temp = list.get(0);
        		list.remove(0);
        		x.add(temp.val);
        		if(temp.left!= null){
        			nums_level++;
        			list.add(temp.left);
        		}
        		if(temp.right!= null){
        			nums_level++;
        			list.add(temp.right);
        		}
        	}
        	result.add(0, x);
        	i=nums_level;
        }
        return result;
    }
	
	
}
