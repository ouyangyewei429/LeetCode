
public class RemoveDuplicatesFromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,1,1,2,3,4,5,5};
		System.out.println(new Solution().removeDuplicates(A));
	}

	public static class Solution {
	    public int removeDuplicates(int[] A) {
//	    	int nRepeats = 0;
//	    	for (int i=0; i<A.length-nRepeats; ++i) {
//	        	int index = i+1;
//	    		for (int j=i+1; j<A.length; ++j) {
//	        		if (A[i] != A[j]) {
//	        			A[index++] = A[j];
//	        			if (index > A.length-nRepeats) {
//	        				break;
//	        			}
//	        		} else if (j <= A.length-nRepeats) {
//	        			++nRepeats;
//	        		}
//	        	}
//	        }
//	    	return A.length - nRepeats;
	    	int length = 0;
	    	for (int i=0; i<A.length; ++i) {
	    		if (0==length || A[i]!=A[length-1]) {
	    			A[length++] = A[i];
	    		}
	    	}
	    	return length;
	    }
	}
}
