class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actual_sum = n*(n+1)/2;

        int currSum= 0;
        for(int i=0; i<n; i++){
            currSum= currSum + nums[i];
        }
        int result = actual_sum - currSum;
         return result;
    }
    
   
}