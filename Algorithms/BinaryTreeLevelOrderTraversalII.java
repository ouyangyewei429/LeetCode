import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversalII {

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
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			int nodeCounters = 0;
			ArrayList<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);  // add root into queue
	        while (!queue.isEmpty()) {
	        	++nodeCounters;
	        	TreeNode node = queue.poll();
	        	if (null == node) {
	        		continue;
	        	}
	        	
	        	// calculate the level of current node
	        	int height = (int)(Math.log10(1.0*nodeCounters)/Math.log10(2.0));
	        	if (levelOrderList.isEmpty() || levelOrderList.size()<=height) {
	        		List<Integer> levelList = new ArrayList<Integer>();
	        		levelList.add(node.val);
	        		if (levelOrderList.isEmpty()) {
	        			levelOrderList.add(levelList);
	        		} else {
	        			levelOrderList.add(0, levelList);
	        		}
	        	} else {
	        		List<Integer> levelList = levelOrderList.get(0);
	        		levelList.add(node.val);
	        	}

	        	queue.add(node.left);
	        	queue.add(node.right);
	        }
	        return levelOrderList;
	    }
	}

	/**
	 * 维护构建二叉树的值和值索引
	 */
	public static class TreeValue {
		public static int index = 0;
		public static final int[] TREE_VALUE = new int[]{1,2,0,3,0,4,0,5,0,0,0};
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
