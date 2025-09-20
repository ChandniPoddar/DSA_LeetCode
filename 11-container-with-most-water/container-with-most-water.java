class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxWat= 0;
        while(start<end){
            int ht = Math.min(height[start],height[end]);
            int width = end- start;
            int currCap = ht * width;
            maxWat = Math.max(currCap, maxWat);
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxWat;
        
    }
}