// 141. Linked List Cycle
// Easy
// Topics - Hash Table, Linked List, Two Pointers
// Companies- Amazon
// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.
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
// -----------Using Hash Set-------------
class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if(seen.contains(cur)){
                return true;
            }
            seen.add(cur);
            cur = cur.next;
        }
        return false;
    }
}
