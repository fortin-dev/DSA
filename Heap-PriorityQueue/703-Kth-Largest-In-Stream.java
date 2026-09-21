/*
    Kth Largest Element in a Stream
    Easy
    Topics
    Company Tags
    Design a class to find the kth largest integer in a stream of values, including duplicates. E.g. the 2nd largest from [1, 2, 3, 3] is 3. The stream is not necessarily sorted.
    Implement the following methods:

    constructor(int k, int[] nums) Initializes the object given an integer k and the stream of integers nums.
    int add(int val) Adds the integer val to the stream and returns the kth largest integer in the stream.
*/
//Using Sorting : everytime we insert -> we sort , so the Kth largest element remains at same positioni -> that is (nums.length - k)
//  O(m*nlogn) tc & O(m + n)sc -> m : no. of call(made to add()) and n : no. of element (curr. size)
class KthLargest {
    List<Integer> arr;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        arr = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
    }

    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - K);
    }
}