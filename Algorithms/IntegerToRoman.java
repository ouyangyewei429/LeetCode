import java.util.Scanner;


public class IntegerToRoman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		while (0 != (num = scanner.nextInt())) {
			System.out.println(new Solution().intToRoman(num));
		}
	}

	public static class Solution {
		public static final String[] ROMAN_STRING = new String[]{
			"M", "CM", "D", "CD", "C", 
			"XC", "L", "XL", "X", "IX",
			"V", "IV", "I"};
		public static final int[] ROMAN_VALUE = new int[]{
			1000, 900, 500, 400, 100,
			90, 50, 40, 10, 9,
			5, 4, 1};
		
	    public String intToRoman(int num) {
	        String roman = new String();
	        while (num > 0) {
	        	for (int i=0; i<ROMAN_VALUE.length; ++i) {
	        		if (num >= ROMAN_VALUE[i]) {
	        			roman += ROMAN_STRING[i];
	        			num -= ROMAN_VALUE[i];
	        			break;
	        		}
	        	}
	        }
	        return roman;
	    }
	}
}