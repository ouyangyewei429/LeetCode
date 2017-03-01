
public class RomantoInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String roman = "MCMLXXX";
		System.out.println(new Solution().romanToInt(roman));
	}

	/**
	 * Calculate from right to left. following the rules below:
	 * 1. if right <= left, then result := right+left
	 * 2. or result := abs(result-left)
	 * 
	 * @author ouyangyewei
	 */
	public static class Solution {
	    public int romanToInt(String s) {
	        final String ROMAN_STRING = "IVXLCDM";
	        final int[] ROMAN_VALUE = new int[]{1,5,10,50,100,500,1000};
	        
	        char lastRoman = 'I';
	        char currRoman = '\0';
	        int result = 0;
	        int length = s.length();
	        for (int i=length-1; i>=0; --i) {
	        	currRoman = s.charAt(i);
	        	int lastRomanValue = ROMAN_VALUE[ROMAN_STRING.lastIndexOf(lastRoman)];
	        	int currRomanValue = ROMAN_VALUE[ROMAN_STRING.lastIndexOf(currRoman)];
	        	if (lastRomanValue <= currRomanValue) {
	        		result += currRomanValue;
	        	}
	        	else {
	        		if (result > currRomanValue) {
	        			result = result - currRomanValue;
	        		}
	        		else {
	        			result = currRomanValue - result;
	        		}
	        	}
	        	
	        	lastRoman = currRoman;
	        }
	        
	        return result;
	    }
	}
}
