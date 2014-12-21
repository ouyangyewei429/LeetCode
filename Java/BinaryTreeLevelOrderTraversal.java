import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        if (null == root) {
            return levelOrderList;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> currentLevelList = new ArrayList<Integer>();
        
        TreeNode lastLevelNode = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            currentLevelList.add(currentNode.val);
            if (currentNode == lastLevelNode) {
                if (null != currentNode.right) {
                    lastLevelNode = currentNode.right;
                } else if (null != currentNode.left) {
                    lastLevelNode = currentNode.left;
                }
                
                levelOrderList.add(currentLevelList);
                currentLevelList = new ArrayList<Integer>();
            }
            
            if (null != currentNode.left) {
                queue.add(currentNode.left);
            }
            if (null != currentNode.right) {
                queue.add(currentNode.right);
            }
        }// end of while
        return levelOrderList;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode();
        root = createTree(root, TreeValue.index);
        List<List<Integer>> levelOrderList = new BinaryTreeLevelOrderTraversal().levelOrder(root);
    }

    /**
     * 维护构建二叉树的值和值索引
     */
    public static class TreeValue {
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[]{1,2,6,0,0,0,3,4,0,7,0,0,5,8,0,0,0};
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
