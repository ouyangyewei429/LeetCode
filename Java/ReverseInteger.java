
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -12345643;
		System.out.println(new Solution().reverse(x));
	}

	public static class Solution {
	    public int reverse(int x) {
	    	long result = 0;
	        boolean isNegative = false;
	        if (x < 0) {
	        	x = -x;
	        	isNegative = true;
	        }
	        
	        while (x > 0) {
	        	result = result*10 + x%10;
	        	x /= 10;
	        }
	        if (result < 0x7fffffff) {
	        	// 2^31-1 = 0x7fffffff
	        	if (!isNegative) {
	        		return (int)result;
	        	} else {
	        		return -(int)result;
	        	}
	        } else {
	        	// overflow
	        	System.exit(1);
	        	return 0;
	        }
	    }
	}
}
