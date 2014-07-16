import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = null;
		CreateBinaryTree(root);
//		InOrder(rootNode);
		List<Integer> inorderList = new Solution().inorderTraversal(rootNode);
		for (Integer val : inorderList) {
			System.out.println(val);
		}
	}
	
	public static class Solution {
		/**
		 * Algorithm:
		 * 
		 * 从某个节点node出发
		 *    1. 向左遍历，边遍历边将节点压入栈
		 *    2. 到达左子树的尽头，从栈中取出节点node并访问值
		 *    3. 转向node节点的右子树
		 */
	    public List<Integer> inorderTraversal(TreeNode root) {
	    	Stack<TreeNode> stack = new Stack<TreeNode>();
	    	List<Integer> inorderList = new ArrayList<Integer>();
	    
	    	TreeNode node = root;
	    	while (null!=node || !stack.empty()) {
	    		while (null != node) {
	    			stack.add(node);
	    			node = node.left;
	    		}
	    		if (!stack.empty()) {
	    			node = stack.pop();
	    			inorderList.add(node.val);
	    			node = node.right;
	    		}
	    	}
	    	return inorderList;
	    }
	}

	private static int index = 0;
	private static int[] TREE_VALUE = new int[]{1,2,3,0,4,5,0,0,6,0,0,7,0,0,8,0,9,10,0,0,0};
	private static TreeNode rootNode = null;
	private static boolean initialize = false;
	
	public static void CreateBinaryTree(TreeNode root) {
		if (0 == TREE_VALUE[index]) {
			root = null;
			return;
		}
		
		if (!initialize) {
			root = new TreeNode(TREE_VALUE[index]);
			rootNode = root;
			initialize = true;
		}
		
		root.setVal(TREE_VALUE[index]);
		
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
	        if (root.val == 0) {
	        	return;
	        }
	        System.out.println(root.val);
	        InOrder(root.right);
	    }
	}/* InOrder */
	
	/**
	 * Definition for binary tree
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		TreeNode() {
			//
		}
		TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
		
		public void setVal(int val) {
			this.val = val;
		}
	}
}
