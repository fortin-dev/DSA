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
