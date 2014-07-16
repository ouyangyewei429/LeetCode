import java.util.ArrayList;
import java.util.Scanner;


public class ReverseWordsInAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "the sky is blue";
		String s = null;
		Scanner sc = new Scanner(System.in);
		while (null != (s = sc.nextLine())) {
			String reverse = new Solution().reverseWords(s);
			System.out.println(reverse);
		}
	}

	public static class Solution {
//	    public String reverseWords(String s) {
//	        if (null == s) {
//	        	// s is null
//	        	return null;
//	        }
//	    	
//	    	s = s.trim();
//	        if (s.length() < 1) {
//	        	// s is fill with space
//	        	return "";
//	        }
//	        
//	        final String DELIMITER = " ";
//	        String reverse = new String();
//	        String[] words = s.split(DELIMITER);
//	        if (words.length == 1) {
//	        	// the first or the last character of s is fill with space
//	        	return s;
//	        } else {
//	        	boolean isFirstWord = true;
//		        for (int i=words.length-1; i>=0; --i) {
//		        	if (words[i].length() >= 1) {
//		        		if (isFirstWord) {
//			        		reverse += words[i];
//			        		isFirstWord = false;
//			        	} else {
//			        		reverse += (DELIMITER + words[i]);
//			        	}
//		        	}
//		        }
//		        return reverse;
//	        }
//	    }
		public String reverseWords(String s) {
	        if (null == s) {
	        	// case when s is null
	        	return null;
	        }
	        
	        int length = s.length();
	        ArrayList<String> words = new ArrayList<String>();
	        for (int i=0; i<length; ) {
	        	String word = new String();
	        	while (i<length && (' '==s.charAt(i) || '\t'==s.charAt(i))) {
	        		++i;
	        	}
	        	while (i<length && ' '!=s.charAt(i) && '\t'!=s.charAt(i)) {
	        		word += s.charAt(i++);
	        	}
	        	if (word.length() >= 1) {
	        		words.add(word);
	        	}
	        }
	        if (words.isEmpty()) {
	        	return "";
	        } else {
	        	String reverse = new String();
	        	boolean isFirstWord = true;
	        	int nWords = words.size();
	        	for (int j=nWords-1; j>=0; --j) {
	        		if (isFirstWord) {
		        		reverse += words.get(j);
		        		isFirstWord = false;
		        	} else {
		        		reverse += (" " + words.get(j));
		        	}
	        	}
	        	return reverse;
	        }
	    }
	}
}
