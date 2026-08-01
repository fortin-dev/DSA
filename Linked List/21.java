// 21. Merge Two Sorted Lists
// Easy
// Topics - LinkedList, Recursion
// Companies - Microsoft
// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

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

// ------------Using Iteration--------------------
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if(list1 != null){
            node.next = list1;
        }else{
            node.next = list2;
        }

        return dummy.next;
    }
}