
public class ClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 44;
		System.out.println(new Solution().climbStairs(n));
	}

	public static class Solution {
		/*
	    public int climbStairs(int n) {
	        if (n == 0) {
	        	return 1;
	        }
	        else if (n < 0) {
	        	return 0;
	        }
	        
	        return climbStairs(n-1) + climbStairs(n-2);
	    }
	    */
		public int climbStairs(int n) {
			final int STAIRS = 50;
	        int[] nSteps = new int[STAIRS];
	        nSteps[0] = 0;
	        nSteps[1] = 1;
	        nSteps[2] = 2;
	        nSteps[3] = 3;
	        for (int i=4; i<STAIRS; ++i) {
	        	nSteps[i] = nSteps[i-1] + nSteps[i-2];
	        }
	        
	        return nSteps[n];
	    }
	}
}
