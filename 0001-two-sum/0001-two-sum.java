public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Guard: null or fewer than 2 elements has no valid pair
        if (nums == null || nums.length < 2) return new int[]{};

        int n = nums.length;
        int[] idx = new int[n];                    // idx[k] = original index of k-th smallest
        for (int i = 0; i < n; i++) idx[i] = i;

        heapSort(idx, nums);                       // sort indices by nums value

        int lo = 0, hi = n - 1;
        while (lo < hi) {                          // lo < hi, so two different elements
            long sum = (long) nums[idx[lo]] + nums[idx[hi]];   // long avoids overflow
            if (sum == target) return new int[]{idx[lo], idx[hi]};
            else if (sum < target) lo++;           // need a bigger sum
            else hi--;                             // need a smaller sum
        }
        return new int[]{};                        // no pair found
    }

    // Iterative heap sort on the index array, comparing by v[idx[...]]
    private void heapSort(int[] idx, int[] v) {
        int n = idx.length;
        for (int i = n / 2 - 1; i >= 0; i--) siftDown(idx, v, i, n);   // build max-heap
        for (int end = n - 1; end > 0; end--) {
            int t = idx[0]; idx[0] = idx[end]; idx[end] = t;           // move max to the end
            siftDown(idx, v, 0, end);
        }
    }

    private void siftDown(int[] idx, int[] v, int i, int size) {
        while (true) {
            int l = 2 * i + 1, r = l + 1, big = i;
            if (l < size && v[idx[l]] > v[idx[big]]) big = l;
            if (r < size && v[idx[r]] > v[idx[big]]) big = r;
            if (big == i) return;
            int t = idx[i]; idx[i] = idx[big]; idx[big] = t;
            i = big;
        }
    }
}
//You are a Senior Java Developer 
//Task: Return the indices of the two numbers such that they add up to target from a given array of integers nums. Assume that each input would have exactly one solution, and you may not use the same element twice.
//Input: int[], int eg. nums = [2,7,11,15], target = 9
//Output: int[], eg. [0,1] , any order

//Constraints: 
//1. Language: Java, use standard library only
//2. O(n)/O(n log n) time complexity , O(1)/O(n) for extra spaces
//3. Edge Cases: null, empty, single element, duplicates, 2 <= nums.length <= 104,109 <= nums[i] <= 10^9, -10^9 <= target <= 10^9
//4. Signature: public int[] twoSum(int[] nums, int target)

//Deliver:
//1. Complete runnable code with comments on key line, time and space complexity
//2. Approach in 2-3 lines
//3. 5 test cases with expected outputs 


