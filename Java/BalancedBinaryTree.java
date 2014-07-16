
public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = null;
		CreateBinaryTree(root);
		System.out.println(new Solution().isBalanced(rootNode));
	}

	public static class Solution {
		public int maxDepthDiff = -1;
		
	    public boolean isBalanced(TreeNode root) {
	    	TreeDepth(root);
	        return (maxDepthDiff <= 1);
	    }
	    /**
	     * record the difference for left child depth and right child depth
	     * @param root
	     * @return
	     */
	    public int TreeDepth(TreeNode root) {
	    	if (null == root) {
	    		return 0;
	    	}
	    	
	    	int left = TreeDepth(root.left);
	    	int right = TreeDepth(root.right);
	    	
	    	int depthDiff = Math.abs(left-right);
	    	if (maxDepthDiff < depthDiff) {
	    		maxDepthDiff = depthDiff;
	    	}
	    	return (left > right ? left+1 : right+1);
	    }
	}
	
	
	private static int index = 0;
//	private static String TREE = "ABD  EHJ  KML OP   N  I  CF  G  ";
//	private static String TREE = "ABC  DE G  F   ";
	private static String TREE = "ABC  D   ";
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
}
