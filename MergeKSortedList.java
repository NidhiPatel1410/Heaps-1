/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// In this problem, using a min heap capped to the size of total list given(k),
// and adding to the heap initial nodes first. Then
// while heap is not empty, polling the node and building the sorted linked
// list. Whichever node gave the element of LL, adding
// the next node of that node to the heap.

// Time Complexity : O(nklogk) - n is the avg length of each list and total
// number of list is k
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Base Case
        if (lists == null || lists.length == 0) {
            return null;
        }
        // Dummy node so we can create new linked from the next of dummy node
        ListNode dummy = new ListNode(-1);
        // Priority queue - min heap having initial nodes in sorted form
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // Add initial nodes to the pq
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        // Set curr to dummy
        ListNode curr = dummy;
        // loop till heap is not empty
        while (!pq.isEmpty()) {
            // Poll the min element and start building the linkedlist
            ListNode polled = pq.poll();
            curr.next = polled;
            // Check if there is next node to the polled node
            if (polled.next != null) {
                // Add it to the pq
                pq.add(polled.next);
            }
            // Move curr
            curr = curr.next;

        }
        // Dummy's next have the head of our sorted linked list
        return dummy.next;

    }
}