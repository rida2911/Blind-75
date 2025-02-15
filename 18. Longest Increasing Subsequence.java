class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer>sub = new ArrayList<>() ;

        for(int num : nums) {
            int idx = Collections.binarySearch(sub , num) ;
           if (idx < 0 ) idx = -(idx + 1) ;
           if(idx == sub .size()) {
            sub.add(num);
           }
           else{
            sub.set(idx , num) ;
           }
        }
        return sub .size();
    }
}
