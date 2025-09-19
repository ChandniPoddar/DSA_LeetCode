class Solution {
    public int dominantIndex(int[] nums) {
        int max=-1;
        int smax =-1;
        int maxInd = 0;
        for(int i=0; i<nums.length; i++){
            if(max<nums[i]){
                smax= max;
                max=nums[i];
                maxInd=i;
            }else if(smax<nums[i]){
                smax=nums[i];
            }
        }
        if(max>=smax*2){
            return maxInd;
        }
        return -1;
    }

}