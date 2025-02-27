class Solution {
    public int[][] merge(int[][] intervals) {
      if(intervals.length <= 1 ) return intervals;

      Arrays.sort(intervals, (a,b) -> a[0] - b[0]) ;
      List<int[]> result = new ArrayList<>() ;
      int [] currentInterval = intervals[0] ;

      for(int i = 1 ; i < intervals.length ; i++) {
        if(intervals[i][0] <= currentInterval[1]) {
            currentInterval[1] = Math.max(currentInterval[1] , intervals[i][1] ) ;
        } else {
            result.add(currentInterval) ;
            currentInterval = intervals[i];
        }
      }


      result.add(currentInterval) ;

      return result.toArray(new int[result.size()][]);
        
    }
}
