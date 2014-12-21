import java.math.BigInteger;

import javax.xml.stream.events.Characters;

public class AddBinary {
//    /**
//     * Convert binary number to BigInteger.
//     * @param binary
//     * @return
//     */
//    public BigInteger convertBinaryToBigInteger(String binary) {
//        BigInteger factor  = BigInteger.ONE;
//        BigInteger convert = BigInteger.ZERO;
//        
//        int length = binary.length();
//        for (int i=length-1; i>=0; --i) {
//            long num = (long)(binary.charAt(i)-'0');
//            convert = convert.add(factor.multiply(BigInteger.valueOf(num)));
//            
//            factor = factor.shiftLeft(1);
//        }
//
//        return convert;
//    }
//    
//    /**
//     * Convert BigInteger to binary number.
//     * @param c
//     * @return
//     */
//    public String convertBigIntegerToBinary(BigInteger c) {
//        if (c.equals(BigInteger.ZERO)) {
//            return "0";
//        }
//        
//        String res = new String();
//        BigInteger factor = BigInteger.valueOf(2L);
//        while (!c.equals(BigInteger.ZERO)) {
//            res += c.mod(factor).toString();
//            c = c.divide(factor);
//        }
//        
//        return new StringBuffer(res).reverse().toString(); 
//    }
//    
//    /**
//     * Add Two given binary number and return the binary number of their sum.
//     * @param a
//     * @param b
//     * @return
//     */
//    public String addBinary(String a, String b) {
//        BigInteger aBigInteger = convertBinaryToBigInteger(a);
//        BigInteger bBigInteger = convertBinaryToBigInteger(b);
//        
//        return convertBigIntegerToBinary(aBigInteger.add(bBigInteger));
//    }
//
//    /**
//     * @param args
//     */
    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println(new AddBinary().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        String convert = new String();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        
        int aByte  = 0;
        int bByte  = 0;
        int carry  = 0;
        int aIndex = aArray.length - 1;
        int bIndex = bArray.length - 1;
        while (aIndex>-1 || bIndex>-1 || carry>0) {
            aByte = aIndex > -1 ? Character.getNumericValue(aArray[aIndex--]) : 0;
            bByte = bIndex > -1 ? Character.getNumericValue(bArray[bIndex--]) : 0;
            
            convert += String.valueOf(aByte ^ bByte ^ carry);
            carry = (aByte + bByte + carry) > 1 ? 1 : 0;
        }// end of while
        
        return new StringBuffer(convert).reverse().toString();
    }
}
