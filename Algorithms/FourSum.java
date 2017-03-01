
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    private List<List<Integer>> fourSumList = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        
        return fourSumList;
    }
    
    public void dfs(int lastIndex, 
            int curIndex, 
            int[] num,
            int sum, 
            int target, 
            List<Integer> list) {
        int nSizes = list.size();
        if (nSizes >= 4) {
            if (nSizes==4 && sum==target) {
                fourSumList.add(list);
            }
        }
    }
}
