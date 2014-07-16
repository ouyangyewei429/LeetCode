import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreorderTraversal {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode();
		root = createTree(root, TreeValue.index);
		
		new Solution().preorderTraversal(root);
//		System.out.println("123");
	}

	public static class Solution {
		/**
		 * Algorithm:
		 * 
		 * 1. push root into stack
		 * when stack is not empty
		 *     2. get node from stack
		 *     3. visit node
		 *     4. if null!=node.right then push node.right end
		 *     5. if null!=node.left then push node.left end
		 */
	    public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> preorderList = new ArrayList<Integer>();
	        if (null == root) {
	    		// Empty tree
	    		return preorderList;
	    	}
	        
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.add(root);
	        while (!stack.empty()) {
	        	TreeNode node = stack.pop();
	        	preorderList.add(node.val);
	        	
	        	if (null != node.right) {
	        		stack.add(node.right);
	        	}
	        	if (null != node.left) {
	        		stack.add(node.left);
	        	}
	        }
	        return preorderList;
	    }
	}
	
	/**
	 * 维护构建二叉树的值和值索引
	 */
	public static class TreeValue {
		public static int index = 0;
		public static final int[] TREE_VALUE = new int[]{1,2,3,0,4,5,0,0,6,0,0,7,0,0,8,0,9,10,0,0,0};
	}
	
	/**
	 * Create A Binary Tree with TreeValue
	 * 
	 * @node: a tree node
	 * @i: the index of tree value
	 */
	public static TreeNode createTree(TreeNode node, int i) {
		if (0 == TreeValue.TREE_VALUE[i]) {
			return null;
		} else {
			node.setVal(TreeValue.TREE_VALUE[i]);
		}
		
		TreeNode leftChild = new TreeNode();
		node.left = createTree(leftChild, ++TreeValue.index);
		TreeNode rightChild = new TreeNode();
		node.right = createTree(rightChild, ++TreeValue.index);

		return node;
	}
	
	/**
	 * Definition for binary tree
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
			left = null;
			right = null;
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
	
//	public static void main(String[] args) {
//		TreeNode root = new TreeNode();
//		root = createTree(root, index);
//	}
}
