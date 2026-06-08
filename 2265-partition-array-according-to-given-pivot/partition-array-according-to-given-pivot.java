class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for(int num : nums){
            if(num < pivot){
                less.add(num);
            }else if(num == pivot){
                equal.add(num);
            }else{
                greater.add(num);
            }
        }
        int[] result = new int[nums.length];
        int idx = 0;
        for(int n : less ) result[idx++] = n;
        for(int n : equal ) result[idx++] = n;
        for(int n : greater) result[idx++] =n;

        return result;
        
    }
}