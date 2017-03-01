
public class MinimumDepthOfBinaryTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(createTree(new TreeLinkNode(), TreeValue.index)));
    }
    
    private int minimumDepth = 0x3fffffff;
    
    public int minDepth(TreeLinkNode root) {
        if (root == null) {
            return 0;
        }
        
        dfs(root, 1);
        return minimumDepth;
    }
    
    public void dfs(TreeLinkNode node, int sum) {
        if (node.left==null && node.right==null) {
            if (sum < minimumDepth) {
                minimumDepth = sum;
            }
            return ;
        }
        
        if (node.left != null) {
            dfs(node.left, sum+1);
        }
        if (node.right != null) {
            dfs(node.right, sum+1);
        }
    }

    /**
     * 维护构建二叉树的值和值索引
     */
    public static class TreeValue {
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[]{1,0,3,6,0,0,7,0,0};
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
