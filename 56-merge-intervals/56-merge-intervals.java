class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int a=intervals[0][1];
        int b=intervals[0][0];
        int d=1;
        for(int i=1;i<intervals.length;i++){
            if(b>intervals[i][0]){
                b=intervals[i][0];
            }
            if(a>=intervals[i][0]){
                a=a>intervals[i][1]?a:intervals[i][1];
            }
            else{
                ++d;
                a=intervals[i][1];
                b=intervals[i][0];
            }
        }
        int[][] interval =new int[d][2]; 
        d=0;
        a=intervals[0][1];
        b=intervals[0][0];
        for(int i=1;i<intervals.length;i++){
            if(b>intervals[i][0]){
                b=intervals[i][0];
            }
            if(a>=intervals[i][0]){
                a=a>intervals[i][1]?a:intervals[i][1];
            }
            else{
                int[] c={b,a};
                interval[d]=c;
                ++d;
                a=intervals[i][1];
                b=intervals[i][0];
            }
        }
        int[] c={b,a};
        interval[d]=c;
        return interval;
    }
}