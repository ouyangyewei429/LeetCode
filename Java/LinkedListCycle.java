
public class LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = CreateList();
		System.out.println(new Solution().hasCycle(head));
	}

	
	public static class Solution {
	    public boolean hasCycle(ListNode head) {
	    	if (null==head || null==head.next) {
	    		return false;
	    	}
	    	
	    	ListNode fast = head;  // fast pointer take one step
	    	ListNode slow = head.next.next;  // slow pointer take two steps
	    	while (null!=fast && null!=slow) {
	    		if (fast == slow) {
	    			// fast pointer meet slow pointer, it means list has cycle!
	    			return true;
	    		}
	    		
	    		if (null == slow.next) {
	    			// it mean slow pointer has reach the list tail! No cycle!
	    			return false;
	    		}
	    		else {
	    			fast = fast.next;
		    		slow = slow.next.next;
	    		}
	    	}
	    	return false;
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
		
		tail.next = head;
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
