import java.util.ArrayList;
import java.util.List;


public class PascalTriangleII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> result = new PascalTriangleII().getRow(3);
        System.out.println("123");
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }
        
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        for (int i=0; i<=rowIndex; ++i) {
            if (i == 0) {
                List<Integer> currTriangle = new ArrayList<Integer>();
                currTriangle.add(1);
                pascalTriangle.add(i, currTriangle);
            } else {
                List<Integer> currTriangle = new ArrayList<Integer>();
                List<Integer> lastTriangle = pascalTriangle.get(i-1);
                
                int lastInteger = 0;
                for (int j=0; j<lastTriangle.size(); ++j) {
                    currTriangle.add(lastInteger + lastTriangle.get(j));
                    lastInteger = lastTriangle.get(j);
                }
                currTriangle.add(1);
                pascalTriangle.add(currTriangle);
            }
        }// end of for
        
        return pascalTriangle.get(rowIndex);
    }
}
