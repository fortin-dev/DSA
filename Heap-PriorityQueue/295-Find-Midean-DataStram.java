/*
    Find Median From Data Stream
    Hard
    Topics
    The median is the middle value in a sorted list of integers. For lists of even length, there is no middle value, so the median is the mean of the two middle values.
    For example:
    For arr = [1,2,3], the median is 2.
    For arr = [1,2], the median is (1 + 2) / 2 = 1.5
    Implement the MedianFinder class:

    MedianFinder() initializes the MedianFinder object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far.
*/

//Using sorting : sort the array when we need to find the median
// O(1)tc for addNum() & O(m*log n)tc for findMedian()
class MedianFinder {
    private ArrayList<Integer> data;
    public MedianFinder() {
        data = new ArrayList<>();
    }

    public void addNum(int num) {
        data.add(num);
    }

    public double findMedian() {
        Collections.sort(data);
        int n = data.size();
        if (!(n%2==0)) {
            return data.get(n / 2);
        } else {
            return (data.get(n / 2) + data.get(n / 2 - 1)) / 2.0;
        }
    }
}
