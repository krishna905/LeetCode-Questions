/*ou are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Input: head = [1,2,3,4]
Output: [1,4,2,3]
*/




class Solution{
public static ListNode reverse(ListNode head){
     if (head==null || head.next==null) return head;
    
    ListNode prv = null;
    ListNode cur = head;
    while(cur!=null){
        ListNode frw = cur.next;        
        cur.next=prv;
        prv = cur;
        cur = frw;
    }

    return prv;
}

public static void merge(ListNode l1,ListNode l2){
    
    while(l2!=null){
        ListNode frw = l1.next;
        l1.next = l2;
        l1= l2;
        l2 = frw;
    }
    
}

public void reorderList(ListNode head) {
    if (head==null || head.next==null) return;
    
    ListNode fast = head;
    ListNode slow = head;
    ListNode prv = null;
    while(fast!=null && fast.next!=null){
        prv = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    
    prv.next = null;
    ListNode l1 = head;
    ListNode l2 = reverse(slow);
    
    merge(l1,l2);
}
}
