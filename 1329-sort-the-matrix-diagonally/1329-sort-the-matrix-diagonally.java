class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<mat[0].length;i++){
            PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
            int a=0;
            int b=i;
            while(a<mat.length && b<mat[0].length){
                queue.add(mat[a][b]);
                a++;
                b++;
            }
            a=0;
            b=i;
            while(a<mat.length && b<mat[0].length){
                mat[a][b]=queue.poll();
                a++;
                b++;
            }
        }
        for(int i=1;i<mat.length;i++){
            PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
            int a=i;
            int b=0;
            while(a<mat.length && b<mat[0].length){
                queue.add(mat[a][b]);
                a++;
                b++;
            }
            a=i;
            b=0;
            while(a<mat.length && b<mat[0].length){
                mat[a][b]=queue.poll();
                a++;
                b++;
            }
        }
        return mat;
    }
}