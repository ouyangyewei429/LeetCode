
public class MaximumDepthOfBinaryTree {

	private static int index = 0;
//	private static String TREE = "ABD  EHJ  KML OP   N  I  CF  G  ";
	private static String TREE = "ABC  DE G  F   ";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = null;
		CreateBinaryTree(root);
		InOrder(rootNode);
		System.out.println(new Solution().maxDepth(rootNode));
	}
	
	private static TreeNode rootNode = null;
	private static boolean initialize = false;
	
	public static void CreateBinaryTree(TreeNode root) {
		if (' ' == TREE.charAt(index)) {
			root = null;
			return;
		}
		
//		root = new TreeNode(TREE.charAt(index));
		if (!initialize) {
			root = new TreeNode(TREE.charAt(index));
			rootNode = root;
			initialize = true;
		}
		
		root.setCh(TREE.charAt(index));
		
		++index;
		root.left = new TreeNode();
		CreateBinaryTree(root.left);
		++index;
		root.right = new TreeNode();
		CreateBinaryTree(root.right);
	}
	
	public static void InOrder(TreeNode root)
	{
	    if (null != root)
	    {
	        InOrder(root.left);
	        if (root.ch == '\0') {
	        	return;
	        }
	        System.out.println(root.ch);
	        InOrder(root.right);
	    }
	}/* InOrder */

	/**
	 * Definition for binary tree
	 */
	public static class TreeNode {
		char ch;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		TreeNode() {}
		
		TreeNode(char c) {
			ch = c;
			left = null;
			right = null;
		}
		
		public void setCh(char ch) {
			this.ch = ch;
		}
	}
	 
	public static class Solution {
	    public int maxDepth(TreeNode root) {
	        if (null == root) {
	        	return 0;
	        }
	        
	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        return (left > right ? left+1 : right+1);
	    }
	}
}
