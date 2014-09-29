
public class SearchA2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 3412;
		int[][] matrix = {
			{1,3,5,7},
			{10,11,16,20},
			{23,30,34,50}
		};
		
		System.out.println(new Solution().searchMatrix(matrix, target));
	}
	
	public static class Solution {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        for (int i=0; i<matrix.length; ++i) {
	        	if (horizontalBinarySearch(matrix, target, matrix[i].length, i)) {
	        		return true;
	        	}
	        }
	        return false;
	    }
	    
	    /**
	     * Binary Search horizontal
	     * @param matrix
	     * @param target
	     * @param length
	     * @param row
	     * @return
	     */
	    public boolean horizontalBinarySearch(int[][] matrix, int target, int length, int row) {
	    	int mid = 0;
	    	int left = 0;
	    	int right = length - 1;
	    	while (left <= right) {
	        	mid = (left + right) / 2;
	        	if (target == matrix[row][mid]) {
	        		return true;
	        	} else if (target < matrix[row][mid]) {
	        		right = mid - 1;
	        	} else {
	        		left = mid + 1;
	        	}
	        }
	        return false;
	    }
	}
}
