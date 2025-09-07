class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        int first_term=0, second_term=1, third_term=1;
        for(int i=1; i<=n; i++){
            int fourth_term = first_term + second_term + third_term;
            first_term=second_term;
            second_term=third_term;
            third_term = fourth_term;
        }
        return first_term;

        
    }
}