class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int a=intervals[0][1];
        int b=intervals[0][0];
        int d=0;
        for(int i=1;i<intervals.length;i++){
            if(a>intervals[i][0]){
                ++d;
            }
            else{
                a=intervals[i][1];
            }
        }
        return d;
    }
}