
public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int elem = 4;
		int[] A = new int[]{1,1,2,2,3,3,4,4,5,6,7,8,9};
		System.out.println(new Solution().removeElement(A, elem));
	}

	public static class Solution {
	    public int removeElement(int[] A, int elem) {
	        int length = 0;
	        for (int i=0; i<A.length; ++i) {
	        	if (elem != A[i]) {
	        		A[length++] = A[i];
	        	}
	        }
	        
	        return length;
	    }
	}
}
