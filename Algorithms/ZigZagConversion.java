
public class ZigZagConversion {
    
    public String convert(String s, int nRows) {
        if (null==s || 0==nRows) {
            return null;
        }
        if (1 == nRows) {
            return s;
        }
        
        char[][] zigzag = fillZigZag(s, nRows);
        
        int nCols = s.length();
        String result = new String();
        for (int i=0; i<nRows; ++i) {
            for (int j=0; j<nCols; ++j) {
                System.out.print(zigzag[i][j]);
                if ('\0' != zigzag[i][j]) {
                    result += zigzag[i][j];
                }
            }
            System.out.println();
        }
        return result;
    }
    
    public char[][] fillZigZag(String s, int nRows) {
        int iRow = 0;
        int iCol = 0;
        int counter = 0;
        int length = s.length() / nRows + nRows*10;
        char[][] zigzag = new char[nRows][length];
        while (counter < length) {
            /** fill down */
            for (; iRow<nRows; ++iRow) {
                if (counter >= length) {
                    break;
                }
                
                zigzag[iRow][iCol] = s.charAt(counter++);
            }
            --iRow;
            
            /** fill upper right */
            for (--iRow,++iCol; iRow>=1; --iRow,++iCol) {
                if (counter >= length) {
                    break;
                }
                
                zigzag[iRow][iCol] = s.charAt(counter++);
            }
        }// end of while
        
        return zigzag;
    }
    
    public static void main(String[] args) {
        System.out.println("----------\n" + new ZigZagConversion().convert("twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd", 4));
    }
}
