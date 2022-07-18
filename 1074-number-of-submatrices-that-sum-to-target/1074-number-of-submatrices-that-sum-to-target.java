class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
        for(int row=0;row<r;row++){
            for(int col=1;col<c;col++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }
        int count=0;
        for(int c1=0;c1<c;c1++){
            for(int c2=c1;c2<c;c2++){
                HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
                map.put(0,1);
                int sum=0;
                for(int row=0;row<r;row++){
                    sum+=matrix[row][c2]-(c1>0?matrix[row][c1-1]:0);
                    count+=map.getOrDefault(sum-target,0);
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;
    }
}