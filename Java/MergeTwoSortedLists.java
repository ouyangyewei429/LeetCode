
public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = CreateList();
		ListNode b = CreateList();
		ListNode merge = new Solution().mergeTwoLists(a, b);
		
		ShowList(merge);
//		System.out.println("123");
	}

	public static class Solution {
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if (null==l1 && null==l2) {
	        	return null;
	        } else if (null == l1) {
	        	return l2;
	        } else if (null == l2) {
	        	return l1;
	        }
	    	
	    	ListNode pa = l1;
	        ListNode pb = l2;
	        ListNode pc = null;
	        ListNode head = null;
	        
	        if (pa.val <= pb.val) {
	        	pc = pa;
	        	pa = pa.next;
	        } else {
	        	pc = pb;
	        	pb = pb.next;
	        }
	        head = pc;
	        
	        while (null!=pa && null!=pb) {
	        	if (pa.val <= pb.val) {
	        		pc.next = pa;
	        		pa = pa.next;
	        	} else {
	        		pc.next = pb;
	        		pb = pb.next;
	        	}
	        	
	        	pc = pc.next;
	        }
	        if (null == pa) {
	        	pc.next = pb;
	        } else if (null == pb) {
	        	pc.next = pa;
	        }
	        
	        return head;
	    }
	}
	
	public static void ShowList(ListNode head) {
		ListNode ptr = head;
		while (null != ptr) {
			System.out.println(ptr.val);
			ptr = ptr.next;
		}
	}
	
	public static ListNode CreateList() {
		ListNode ptr = null;
		ListNode head = null;
		ListNode tail = null;
		int[] value = new int[]{6,5,4,3,2,1};
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
