
public class SwapNodesInPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = CreateList();
		ListNode swap = new Solution().swapPairs(head);
		
		System.out.println("123");
	}

	public static class Solution {
	    public ListNode swapPairs(ListNode head) {
	        if (null == head) {
	        	return null;
	        }
	    	
	    	ListNode pre = head;
	        ListNode post = null;
	        ListNode swapA = head;
	        ListNode swapB = null;
	        while (null != pre) {
	        	if (head == pre) {
	        		// begin with the list head
	        		if (null != pre.next) {
	        			swapA = pre;
	        			swapB = swapA.next;
	        			post = swapB.next;
	        			
	        			// swap node pair
	        			swapA.next = post;
	        			swapB.next = swapA;
	        			head = swapB;
	        		} else {
	        			break;
	        		}
	        	} else {
//	        		pre = swapA;  // after swap
	        		if (null != pre.next) {
		        		swapA = pre.next;
		        		if (null != swapA.next) {
		        			swapB = swapA.next;
		        			post = swapB.next;
		        			
		        			// swap node pair
		        			pre.next = swapB;
		            		swapB.next = swapA;
		            		swapA.next = post;
		        		} else {
		        			break;  // last one node, don't swap
		        		}
		        	} else {
		        		break;  // end of the list
		        	}
	        	}
	        	
	        	pre = swapA;  // after swap
	        }
	        
	        return head;
	    }
	}
	
	public static ListNode CreateList() {
		ListNode ptr = null;
		ListNode head = null;
		ListNode tail = null;
		int[] value = new int[]{1, 2, 3, 4, 5, 6};
		for (int i=0; i<value.length; ++i) {
			if (null == head) {
				head = new ListNode(value[i]);
				tail = head;
				ptr = head;
			}
			else {
				ptr = new ListNode(value[i]);
				ptr.next = head;
				head = ptr;
			}
		}
		
//		tail.next = head;
		return head;
	}
	
	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val = x;
			next = null;
		}
	}
}
