class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 ) 
        return 0 ;
        if(nums.length == 1 ) 
        return nums[0] ;
        

        int case1 = robLinear(nums,0,nums.length-2);
        int case2 = robLinear(nums,1,nums.length-1) ;

        return Math.max(case1  , case2) ;
    }
    private int robLinear(int[] num , int start , int end) {
        int prev1 = 0 , prev2 = 0 ;

        for(int i = start ; i<=end ; i++){
            int temp = prev1 ;
            prev1 = Math.max(prev1 , prev2  + num[i]);
            prev2 = temp ;
        }
        return prev1;
    }
}
