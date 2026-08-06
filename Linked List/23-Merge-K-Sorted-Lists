/*
Merge K Sorted Linked Lists
Hard
Topics- Linked List, Divide and Conquer, Heap (Priority Queue), Merge Sort, Tournament Sort
Company Tags - Facebook
You are given an array of k linked lists lists, where each list is sorted in ascending order.
Return the sorted linked list that is the result of merging all of the individual linked lists.
Example 1:
Input: lists = [[1,2,4],[1,3,5],[3,6]]
Output: [1,1,2,3,3,4,5,6]
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
// Brute force approach - O(nlogn)tc & O(n)sc
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        for(ListNode lst : lists){
            while(lst!=null){
                nodes.add(lst.val);
                lst = lst.next;
            }
        }
        Collections.sort(nodes);

        ListNode res = new ListNode(0);
        ListNode cur = res;
        for(int node : nodes){
            cur.next = new ListNode(node);
            cur = cur.next ;
        }
        return res.next;
    }
}

// Merge two lists at a time - O(n*log-k)tc & O(n)sc
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> temp = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
                temp.add(mergeLists(l1, l2));
            }
            lists = temp.toArray(new ListNode[0]);
        }

        return lists[0];        
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode ans = node;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        node.next = l1 != null ? l1 : l2;
        return ans.next;
    }    
}