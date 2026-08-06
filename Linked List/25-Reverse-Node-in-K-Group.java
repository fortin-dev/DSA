/*
    25. Reverse Nodes in k-Group
    Hard
    Topics
    premium lock icon
    Companies
    Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
    You may not alter the values in the list's nodes, only nodes themselves may be changed.
    Example 1:
    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]
*/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while(true){
            ListNode kth = getKth(groupPrev, k);
            if(kth == null){
                break;
            }
            ListNode groupNext = kth.next;

            ListNode prev = kth.next;
            ListNode cur = groupPrev.next;
            while(cur != groupNext){
                ListNode tmp = cur.next;
                cur.next = prev ;
                prev = cur;
                cur = tmp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }
    private ListNode getKth(ListNode cur , int k){
        while(cur != null && k>0){
            cur = cur.next;
            k--;
        }
        return cur;
    }
}