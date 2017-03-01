import java.util.Arrays;


public class NQueensII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(new Solution().totalNQueens(n));
	}

	public static class Solution {
		final int CHECK_NUMBER = 3;  // check tree points: col, left diagonal and right diagonal
	    final int MAX_NUMBER = 1024;
	    
	    int nSolutions = 0;
		boolean[][] isVisited = new boolean[CHECK_NUMBER][MAX_NUMBER];
		
		public int totalNQueens(int n) {
	        for (int i=0; i<CHECK_NUMBER; ++i) {
	        	isVisited[i] = new boolean[MAX_NUMBER];
	        }
	        
	        dfs(0, n);
	        return nSolutions;
	    }
		
		/**
		 * boolean[0][MAXN]:
		 *
		 * 0: check the col
		 * 1: check the left diagonal
		 * 2. check the right diagonal
		 * 
		 */
		public void dfs(int row, int nGirds) {
			if (row == nGirds) {
				++nSolutions;
				return ;
			}
			
			for (int col=0; col<nGirds; ++col) {
				if (!isVisited[0][col] 
				 && !isVisited[1][row-col+nGirds]
				 && !isVisited[2][row+col]) {
					isVisited[0][col] = true;
					isVisited[1][row-col+nGirds] = true;
					isVisited[2][row+col] = true;
					dfs(row+1, nGirds);
					isVisited[0][col] = false;
					isVisited[1][row-col+nGirds] = false;
					isVisited[2][row+col] = false;
				}
			}
		}
	}
}