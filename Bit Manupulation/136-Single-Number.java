/*
    136. Single Number
    Easy
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.
*/
/* Using set : Math logic : O(n)tc & sc
eg [1,1,2,2,3] be our array
its set will be : [1,2,3] -> 2*set will be : (1+2+3)*2 == 12
normal array sum : 1+1+2+2+3 = 9
difference : 12-9 = 3(our answer)
-- [1,1,2,2,3,3] - visual rep+ of above
-- [1,1,2,2,3] - 3 is the difference hence answer
*/
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum1 = Arrays.stream(nums).sum();
        for(int n : nums){
            set.add(n);
        }
        int sum2 = 0; 
        for(int n : set){
            sum2+=n;
        }
        return 2*sum2 - sum1;
    }
}

// Using XOR operator : O(n)tc & O(1)sc
/*
    XOR properties which helps us solve this : 
    1. x^x = 0
    2. x^0 = x
    3. x^y = y^x
    4. (a^b)^c = a^(b^c)
*/
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int n : nums){
            res^=n;
        }
        return res;
    }
}