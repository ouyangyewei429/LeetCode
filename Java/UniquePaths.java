
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 1;
		int n = 1;
		System.out.println(new Solution().uniquePaths(m, n));
	}

	public static class Solution {
		public final int MAX_SIZE = 124;
		
		private int nSolutions = 0;
		private boolean[][] isVisited = new boolean[MAX_SIZE][MAX_SIZE];
		
	    public int uniquePaths(int m, int n) {
	        for (int i=0; i<m; ++i) {
	        	isVisited[i] = new boolean[n];
	        }
	        dfs(0, 0, m, n);
	        return nSolutions;
	    }
	    
	    public void dfs(int x, int y, int row, int col) {
	    	if (x==row-1 && y==col-1) {
	    		++nSolutions;
	    		return ;
	    	}
	    	
	    	// down one step
	    	if (x+1<row && y<col && !isVisited[x+1][y]) {
	    		isVisited[x+1][y] = true;
	    		dfs(x+1, y, row, col);
	    		isVisited[x+1][y] = false;
	    	}
	    	// right one step
	    	if (x<row && y+1<col && !isVisited[x][y+1]) {
	    		isVisited[x][y+1] = true;
	    		dfs(x, y+1, row, col);
	    		isVisited[x][y+1] = false;
	    	}
	    }
	}
}
