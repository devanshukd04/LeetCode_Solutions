class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxOverlaps=0;
        for(int yShift=0;yShift<img1.length;++yShift){
            for(int xShift=0;xShift<img1.length;++xShift){
                maxOverlaps=Math.max(maxOverlaps,shiftAndCount(xShift,yShift,img1,img2));
                maxOverlaps=Math.max(maxOverlaps,shiftAndCount(xShift,yShift,img2,img1));
            }
        }
        return maxOverlaps;
    }
    public int shiftAndCount(int xShift,int yShift,int[][] M,int[][] R){
        int leftShiftCount=0;
        int rightShiftCount=0;
        int rRow=0;
        for(int mRow=yShift;mRow<M.length;++mRow){
            int rCol=0;
            for(int mCol=xShift;mCol<M.length;++mCol){
                if(M[mRow][mCol]==1 && M[mRow][mCol]==R[rRow][rCol]){
                    leftShiftCount+=1;
                }
                if(M[mRow][rCol]==1 && M[mRow][rCol]==R[rRow][mCol]){
                    rightShiftCount+=1;
                }
                rCol+=1;
            }
            rRow+=1;
        }
        return Math.max(leftShiftCount,rightShiftCount);
    }
}