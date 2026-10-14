/*
    3723. Maximize Sum of Squares of Digits
    Medium
    Topics
    You are given two positive integers num and sum.
    A positive integer n is good if it satisfies both of the following:
    The number of digits in n is exactly num.
    The sum of digits in n is exactly sum.
    The score of a good integer n is the sum of the squares of digits in n.
    Return a string denoting the good integer n that achieves the maximum score. If there are multiple possible integers, return the maximum ​​​​​​​one. If no such integer exists, return an empty string.
*/
//Approach :- Greedily Pick largest digit 9
//O(num)tc, we form a string of num digits
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9)
            return "";

        int nines = sum / 9;
        int remain = sum % 9;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nines; i++) {
            result.append('9');
        }

        if (remain > 0) {
            result.append((char) (remain + '0'));
        }

        while (result.length() < num) {
            result.append('0');
        }

        return result.toString();
    }
}