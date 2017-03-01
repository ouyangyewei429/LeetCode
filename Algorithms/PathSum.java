
public class PathSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new PathSum().hasPathSum(createTree(new TreeLinkNode(), TreeValue.index), 11));
    }
    
    public boolean hasPathSum(TreeLinkNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return dfs(root, root.val, sum);
    }
    
    public boolean dfs(TreeLinkNode node, int sum, int target) {
        if (node.left==null && node.right==null && sum==target) {
            return true;
        }
        
        if (node.left != null) {
            if (dfs(node.left, sum+node.left.val, target)) {
                return true;
            }
        }
        if (node.right != null) {
            if (dfs(node.right, sum+node.right.val, target)) {
                return true;
            }
        }
        return false;
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
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;
        
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
