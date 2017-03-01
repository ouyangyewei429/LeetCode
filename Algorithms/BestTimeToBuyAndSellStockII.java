
public class BestTimeToBuyAndSellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[]{1,1,3,2,5,7,1,3,2,0};
		int maxProfile = new Solution().maxProfit(prices);
		System.out.println(maxProfile);
	}

	public static class Solution {
	    public int maxProfit(int[] prices) {
	    	if (0 == prices.length) {
	    		// Empty array
	    		return 0;
	    	}
	    	
	        int maxProfile = 0;
	        int sellIn = prices[0];
	        for (int i=1; i<prices.length; ++i) {
	        	if (prices[i] > sellIn) {
	        		maxProfile += (prices[i]-sellIn);
	        		sellIn = prices[i];
	        	} else {
	        		sellIn = prices[i];
	        	}
	        }
	        return maxProfile;
	    }
	}
}
