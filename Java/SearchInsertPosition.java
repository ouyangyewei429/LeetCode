
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 10;
		int[] A = new int[]{-1,1,2,3,4,8,9,100};
		System.out.println(new Solution().searchInsert(A, target));
	}

	public static class Solution {
		/*
	    public int searchInsert(int[] A, int target) {
	        int i = 0;
	    	for (; i<A.length; ++i) {
	        	if (target <= A[i]) {
	        		break;
	        	}
	        }
	    	return i;
	    }
	    */
		public int searchInsert(int[] A, int target) {
	        int left = 0;
	        int right = A.length - 1;
	    	int mid = (left + right) / 2;
	    	while (left <= right) {
	    		if (target == A[mid]) {
	    			break;
	    		}
	    		else if (target < A[mid]) {
	    			right = mid - 1;
	    		}
	    		else {
	    			left = mid + 1;
	    		}
	    		
	    		mid = (left + right) / 2;
	    	}
	    	
	    	if (target == A[mid]) {
	    		return mid;
	    	}
	    	else {
	    		return left;
	    	}
	    }
	}
}
