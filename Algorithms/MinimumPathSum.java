
public class MinimumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 5;
		int n = 5;
		int[][] grid = {
			{1,3,2,4,0},
			{4,5,7,9,0},
			{1,1,1,2,3},
			{2,5,8,7,4},
			{1,2,3,4,5}};
		System.out.println(new Solution().minPathSum(grid));
	}
	
	public static class Solution {
		int minSum = 0x7fffffff;
	    boolean[][] isVisited;
		
		public int minPathSum(int[][] grid) {
	        if (null == grid) {
	        	return 0;
	        }
	        
	    	int row = grid.length;
	        int col = grid[0].length;
	        isVisited = new boolean[row][col];
	        for (int i=0; i<row; ++i) {
	        	isVisited[i] = new boolean[col];
	        }
	        
	        dfs(grid, 0, 0, 0, row, col);
	        return minSum;
	    }
		
		public void dfs(int[][] grid, int sum, int x, int y, int row, int col) {
			if (x==row-1 && y==col-1) {
				if (minSum > sum) {
					minSum = sum;
				}
				return ;
			}
			
			// down one step
			if (x+1<row && y<col && !isVisited[x+1][y]) {
				isVisited[x+1][y] = true;
				dfs(grid, sum+grid[x+1][y], x+1, y, row, col);
				isVisited[x+1][y] = false;
			}
			// right one step
			if (x<row && y+1<col && !isVisited[x][y+1]) {
				isVisited[x][y+1] = true;
				dfs(grid, sum+grid[x][y+1], x, y+1, row, col);
				isVisited[x][y+1] = false;
			}
		}
	}

}
