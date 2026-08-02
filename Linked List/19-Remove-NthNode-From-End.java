// 19. Remove Nth Node From End of List
// Medium
// Topics - Linked List, two pointer
// Companies - Oracle
// Given the head of a linked list, remove the nth node from the end of the list and return its head.

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
 //---------Brute Force - Using List---O(n)tc & O(n)sc------------
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            nodes.add(cur);
            cur = cur.next;
        }
        int idx = nodes.size() - n;
        if(idx == 0){
            return head.next;
        }
        nodes.get(idx - 1).next = nodes.get(idx).next;
        return head;
    }
}
//--------Iteration-Two Pass - O(N)tc
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int N = 0;
        ListNode cur = head;
        while(cur != null){
            N++;
            cur = cur.next;
        }
        int removeIndex  = N-n;
        if(removeIndex == 0){
            return head.next;
        }
        cur = head;
        for(int i =0; i<N-1 ; i++){
            if(i+1 == removeIndex ){
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
// ------best Approach - Using two pointer - O(n)tc
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        while(n>0){
            right = right.next;
            n--;
        }
        while(right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}