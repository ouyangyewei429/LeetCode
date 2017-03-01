import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversalIINew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode();
		root = createTree(root, TreeValue.index);
		List<List<Integer>> levelOrderList = new Solution().levelOrderBottom(root);
	}
	
	public static class Solution {
		ArrayList<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
		
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			dfs(root, 0);
			
			ArrayList<List<Integer>> levelOrderReverseList = new ArrayList<List<Integer>>();
			for (List<Integer> levelOrder : levelOrderList) {
				levelOrderReverseList.add(0, levelOrder);
			}
			return levelOrderReverseList;
		}
		
		public void dfs(TreeNode node, int height) {
			if (null == node) {
				return ;
			}
			
			if (levelOrderList.isEmpty() || levelOrderList.size()<height+1) {
				List<Integer> levelOrder = new ArrayList<Integer>();
				levelOrder.add(node.val);
				levelOrderList.add(height, levelOrder);
			} else if (levelOrderList.size() >= height+1) {
				List<Integer> levelOrder = levelOrderList.get(height);
				levelOrder.add(node.val);
			}
			dfs(node.left, height+1);
			dfs(node.right, height+1);
		}
	}

	/**
	 * 维护构建二叉树的值和值索引
	 */
	public static class TreeValue {
		public static int index = 0;
		public static final int[] TREE_VALUE = new int[]{1,2,0,0,3,4,0,5,0,0,0};
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
}
