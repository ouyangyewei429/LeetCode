
public class SingleNumber {
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{2,2,3,4,4,5,5,6,6,8,8};
		
		Solution obj = new Solution();
		int result = obj.singleNumber(A);
		System.out.println(result);
	}
*/
	public static class Solution {
	    public int singleNumber(int[] A) {
	        int result = A[0];
	        for (int i=1; i<A.length; ++i) {
	        	result ^= A[i];
	        }
	        return result;
	    }
	}
/*
	public static class Solution {
	    public int singleNumber(int[] A) {
	        
	    }
	}
	*/
}
