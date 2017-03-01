
public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = CreateList();
		ListNode newHead = new Solution().deleteDuplicates(head);
		ShowList(newHead);
	}

	public static class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	    	if (null == head) {
	    		// empty list
	    		return null;
	    	}
	    	
	        ListNode ptr = head;
	        ListNode dupPtr = head.next;
	        while (null != dupPtr) {
	        	while (null!=dupPtr && ptr.val==dupPtr.val) {
	        		dupPtr = dupPtr.next;
	        	}
	        	if (null != dupPtr) {
	        		ptr.next = dupPtr;
	        		ptr = dupPtr;
	        		dupPtr = dupPtr.next;
	        	}
	        }
	        ptr.next = null;
	        
	        return head;
	    }
	}
	
	public static ListNode CreateList() {
		ListNode ptr = null;
		ListNode head = null;
		ListNode tail = null;
		int[] value = new int[]{1,1,2,2,3,3,4,4,4,4,5,5,5,6,7,8,9,9,9,9,9,9,9,9,10};
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
	
	public static void ShowList(ListNode head) {
		ListNode ptr = head;
		while (null != ptr) {
			System.out.println(ptr.val);
			ptr = ptr.next;
		}
	}
	
	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
