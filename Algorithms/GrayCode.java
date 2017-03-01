import java.util.ArrayList;
import java.util.List;


public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		List<Integer> grayCodeList = new Solution().grayCode(n);
		for (int grayCode : grayCodeList) {
			System.out.println(grayCode);
		}
	}

	public static class Solution {
		/**
		 * Algorithm:
		 * 
		 * binary	binary>>1	gray
		 * --------------------------
		 * 000		000			000
		 * 001		000			001
		 * 010		001			011
		 * 011		001			010
		 * 100		010			110
		 * 101		010			110
		 * 110		011			101
		 * 111		011			100
		 * 
		 * find : garyCode = x ^ (x>>1)
		 * 
		 */
	    public List<Integer> grayCode(int n) {
	        List<Integer> grayCodeList = new ArrayList<Integer>();
	    	
	    	int nLoops = (1 << n);  // 2^n-1
	    	for (int i=0; i<nLoops; ++i) {
	    		int grayCode = (i ^ (i >> 1));
	    		
	    		grayCodeList.add(grayCode);
	    	}
	    	return grayCodeList;
	    }
	}
}

