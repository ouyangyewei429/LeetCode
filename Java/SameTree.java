
public class SameTree {

	private static int index;
	private final static String TREE_A = "ABC  DE G  F   ";
	private final static String TREE_B = "ABC  DE X  F   ";
	
	private static boolean initialize;
	private static TreeNode rootNodeA = null;
	private static TreeNode rootNodeB = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootA = null;
		index = 0;
		initialize = false;
		CreateBinaryTree(rootA, 1);
		
		TreeNode rootB = null;
		index = 0;
		initialize = false;
		CreateBinaryTree(rootB, 2);
		
		InOrder(rootNodeA);
		InOrder(rootNodeB);
		
		System.out.println(new Solution().isSameTree(rootNodeA, rootNodeB));
	}
	
	public static void CreateBinaryTree(TreeNode root, int flag) {
		if (flag == 1) {
			if (' ' == TREE_A.charAt(index)) {
				root = null;
				return ;
			}
			
			if (!initialize) {
				root = new TreeNode();
				rootNodeA = root;
				initialize = true;
			}
			
			root.setVal(TREE_A.charAt(index));
		}
		else {
			if (' ' == TREE_B.charAt(index)) {
				root = null;
				return ;
			}
			
			if (!initialize) {
				root = new TreeNode();
				rootNodeB = root;
				initialize = true;
			}
			
			root.setVal(TREE_B.charAt(index));
		}
		
		++index;
		root.left = new TreeNode();
		CreateBinaryTree(root.left, flag);
		++index;
		root.right = new TreeNode();
		CreateBinaryTree(root.right, flag);
	}
	
	public static void InOrder(TreeNode root)
	{
	    if (null != root)
	    {
	        InOrder(root.left);
	        if (root.val == '\0') {
	        	return;
	        }
	        System.out.println(root.val);
	        InOrder(root.right);
	    }
	}/* InOrder */
	
	public static class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        if (null==p && null!=q) {
	        	return false;
	        }
	        else if (null!=p && null==q) {
	        	return false;
	        }
	        else if (null==p && null==q) {
	        	return true;
	        }
	        else {
	        	if (p.val != q.val) {
	        		return false;
	        	}
	        	
	        	if (!isSameTree(p.left, q.left)) {
	        		return false;
	        	}
	        	if (!isSameTree(p.right, q.right)) {
	        		return false;
	        	}
	        	return true;
	        }
	    }
	}
	
	/**
	 * Definition for binary tree
	 */
	public static class TreeNode {
		char val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
			//
		}
		TreeNode(char c) {
			this.val = c;
			left = null;
			right = null;
		}
		public void setVal(char c) {
			this.val = c;
		}
	}
}
