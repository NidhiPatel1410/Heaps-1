// In this problem, we are inserting elements in min heap one by one, and the size of the min heap is capped by k. So, anytime the 
// size is greater than k, we are doing extract min. 

// Time Complexity : O(nlogk) - n insertions in heap of size k
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // In java priority queue is by default min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        // Loop till length of nums
        for (int i = 0; i < n; i++) {
            // Add in pq
            pq.add(nums[i]);
            // Check size if it is greater than k
            if (pq.size() > k) {
                // Then poll
                pq.poll();
            }
        }
        // At end the element at the root is our kth largest element
        return pq.poll();
    }
}

// Another solution using max heap, where we have capped the size to n-k. And at
// last whatever is the min of all the polled elements
// is our kth largest element

// Time Complexity : O(nlog(n-k)) - n insertions in heap of size k
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Declare a min, so that whenever we poll, we know that we will be polling max
        // values
        // So from k polled elements, min value is our ans (bcoz we want kth largest)
        int min = Integer.MAX_VALUE;
        // Write in below way for pq to work as max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);
            // Capped size n-k
            if (pq.size() > (n - k)) {

                min = Math.min(min, pq.poll());
            }
        }
        return min;
    }
}