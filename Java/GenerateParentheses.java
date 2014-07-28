import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class GenerateParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		List<String> parenthesesList = new Solution().generateParenthesis(n);
		for (String parentheses : parenthesesList) {
			System.out.println(parentheses);
		}
	}

	public static class Solution {
		private List<String> parenthesesList = new ArrayList<String>(); 
		
	    public List<String> generateParenthesis(int n) {
	        Stack<String> stack = new Stack<String>();
	        dfs(stack, "", n);
	        return parenthesesList;
	    }
	    
	    /**
	     * Algorithm:
	     * 
	     * 1. Add "(", stack push "(" directly
	     * 2. Add ")", if the top of stack is "(", pop it
	     * 
	     */
	    public void dfs(Stack<String> stack, String parentheses, int nParentheses) {
	    	if (parentheses.length() >= nParentheses*2) {
	    		if (parentheses.length()==nParentheses*2 && stack.empty()) {
	    			parenthesesList.add(parentheses);
	    		}
	    		return ;
	    	}
	    	
	    	// push "("
	    	stack.push("(");
	    	dfs(stack, parentheses+"(", nParentheses);
	    	stack.pop();
	    	// push ")"
	    	if (!stack.empty() && stack.peek()=="(") {
	    		stack.pop();
	    		dfs(stack, parentheses+")", nParentheses);
	    		stack.push("(");
	    	}
	    }
	}
}