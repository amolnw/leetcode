/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode i = dummy, j = dummy;
        while(j.next != null) {
            if ( n > 0 ) {
                j = j.next;
                n--;
            }
            else {
                j = j.next;
                i = i.next;
            }
        }
        
        i.next = i.next.next; 
        return dummy.next;
    }
}


/*

1



i 
j


*/
    