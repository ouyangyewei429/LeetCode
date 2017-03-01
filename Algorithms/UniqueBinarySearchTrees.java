
public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().numTrees(10));
	}
	
	public static class Solution {
	    public int numTrees(int n) {
	    	final int BST_LENGTH = 10004;
	        int[] nBst = new int[BST_LENGTH];
	        nBst[0] = 0;
	        nBst[1] = 1;
	        nBst[2] = 2;
	        nBst[3] = 5;
	        for (int i=4; i<=n; ++i) {
	        	nBst[i] = nBst[i-1]*2 + nBst[n-2];
	        }
	        
	        return nBst[n];
	    }
	}

}
