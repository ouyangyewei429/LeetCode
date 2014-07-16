
public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,2,3,0,0,0};
		int[] B = new int[]{1,2,3};
		new Solution().merge(A, 3, B, B.length);
		
		System.out.println("123");
	}

	public static class Solution {
	    public void merge(int A[], int m, int B[], int n) {
	    	for (int i=0; i<n; ++i) {
	    		int j = m-1;
	        	while (j>=0 && B[i]<A[j]) {
	        		A[j+1] = A[j];
	        		--j;
	        	}
	        	A[j+1] = B[i];
	        	++m;
	        }
	    }
	}
}
