/*
    3622. Check Divisibility by Digit Sum and Product
    Solved
    Easy
    Topics
    premium lock icon
    Companies
    Hint
    You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:
    The digit sum of n (the sum of its digits).
    The digit product of n (the product of its digits).
    Return true if n is divisible by this sum; otherwise, return false.
    Example 1:
    Input: n = 99
    Output: true
*/
class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int product = 1;
        while(num > 0){
            sum+=num%10;
            product*=num%10;
            num=num/10;
        }
        return n%(sum+product) == 0; 
    }
}