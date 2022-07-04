class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> a=new PriorityQueue<Integer>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                a.add(matrix[i][j]);
            }
        }
        while(k-1>0){
            a.poll();
            k--;
        }
        return a.poll();
    }
}