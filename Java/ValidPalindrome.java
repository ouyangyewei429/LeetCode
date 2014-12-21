
public class ValidPalindrome {

    /**
     * Check if string is palindrome.
     * <p>Empty String is palindrome, 
     * because palindrome only consider alphanumeric characters,
     * so any string like "*-+*" is consider to be palindrome. 
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        
        boolean isPalindrome = true;
        int iHead = 0;
        int iTail = s.length() - 1;
        char[] strs = s.toLowerCase().toCharArray();
        while (iHead <= iTail) {
            while (iHead<strs.length 
                && !Character.isLetter(strs[iHead])
                && !Character.isDigit(strs[iHead])) {
                ++iHead;
            }
            while (iTail >= 0 
                && !Character.isLetter(strs[iTail])
                && !Character.isDigit(strs[iTail])) {
                --iTail;
            }
            if (iHead > iTail) {
                break;
            } else if (strs[iHead] != strs[iTail]) {
                return false;
            }
            
            ++iHead;
            --iTail;
        }// end of while
        
        return isPalindrome;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("*-**"));
    }
}
