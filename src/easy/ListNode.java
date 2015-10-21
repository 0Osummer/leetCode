package easy;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		val = x;
	}	
	
    public void deleteNode(ListNode node) {
    	if(node.next != null){
    		node.val = node.next.val;
    		node.next = node.next.next;
    	}
    	else node = null;
    }
    
    /**
     * Given a sorted linked list, 
     * delete all duplicates such that each element appear only once.
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null) return null;
    	ListNode deDuplicateList = new ListNode(head.val);
    	ListNode temp = deDuplicateList;
    	while(head.next != null){
    		if(head.next.val != temp.val){
    			temp.next = new ListNode(head.next.val);
    			temp = temp.next;
    		}
    		head = head.next;
    	}
        return deDuplicateList;
    }
    
    /**
     * Reverse a singly linked list
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
    	ListNode a = new ListNode(head.val);
    	a.next = null;
    	while(head.next != null){
    		head = head.next;
    		ListNode temp = new ListNode(head.val);
    		temp.next = a;
    		a = temp;
    	}
    	return a;
    }
    
    /**
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes
     * of the first two lists.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1 != null && l2 != null){
        	if(l1.val > l2.val){
        		temp.next = new ListNode(l2.val);
        		temp = temp.next;
        		l2 = l2.next;
        	}
        	else{
        		temp.next = new ListNode(l1.val);
        		temp = temp.next;
        		l1 = l1.next;	
        	}
        }
        temp.next=(l1 == null ? l2 : l1);
        return head.next;
        
    }
}
