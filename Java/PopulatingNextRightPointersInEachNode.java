import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointersInEachNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode();
		root = createTree(root, TreeValue.index);
		new Solution().connect(root);
	}
		 
	public static class Solution {
		/**
		 * Algorithm:
		 * 
		 * push root into queue
		 * while queue is not empty
		 *     get and pop the top tree node from queue
		 *     if queue has any tree node more
		 *         if current_node and next_node at the same depth
		 *         then current_node.next = next_node
		 *     push current.node.left and current_node.right into queue
		 * 
		 */
	    public void connect(TreeLinkNode root) {
	    	if (null == root) {
	    		// Empty Tree
	    		return ;
	    	}
	    	
	        int counter = 0;  // means the ith node of the tree
	    	Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	        	TreeLinkNode node = queue.poll();
	        	++counter;
	        	if (!queue.isEmpty()) {
	        		int curDepth = (int)(Math.log(1.0*counter)/Math.log(2.0));
	        		int nextDepth = (int)(Math.log(1.0*counter+1.0)/Math.log(2.0));
	        		if (curDepth == nextDepth) {
	        			TreeLinkNode nextNode = queue.peek();
	        			node.next = nextNode;
	        		}
	        	}
	        	
        		if (null != node.left) {
        			queue.add(node.left);
        		}
        		if (null != node.right) {
        			queue.add(node.right);
        		}
	        }
	    }
	}

	/**
	 * 维护构建二叉树的值和值索引
	 */
	public static class TreeValue {
		public static int index = 0;
		public static final int[] TREE_VALUE = new int[]{1,2,4,0,0,5,0,0,3,6,0,0,7,0,0};
	}
	
	/**
	 * Create A Binary Tree with TreeValue
	 * 
	 * @node: a tree node
	 * @i: the index of tree value
	 */
	public static TreeLinkNode createTree(TreeLinkNode node, int i) {
		if (0 == TreeValue.TREE_VALUE[i]) {
			return null;
		} else {
			node.setVal(TreeValue.TREE_VALUE[i]);
		}
		
		TreeLinkNode leftChild = new TreeLinkNode();
		node.left = createTree(leftChild, ++TreeValue.index);
		TreeLinkNode rightChild = new TreeLinkNode();
		node.right = createTree(rightChild, ++TreeValue.index);

		return node;
	}
	
	/**
	 * Definition for binary tree
	 */
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
		
		TreeLinkNode() {
			left = null;
			right = null;
			next = null;
		}
		TreeLinkNode(int val) {
			this.val = val;
			left = null;
			right = null;
			next = null;
		}
		
		public void setVal(int val) {
			this.val = val;
		}
	}
}
