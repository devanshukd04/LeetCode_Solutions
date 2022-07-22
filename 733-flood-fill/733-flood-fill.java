class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] check =new int[image.length][image[0].length];
        int color1=image[sr][sc];
        fill(image,check,sr,sc,color,color1);
        return image;
    }
    public void fill(int[][] image,int[][] check,int i,int j,int color,int color1){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || check[i][j]==1){
            return;
        }
        if(image[i][j]!=color1){
            return;
        }
        check[i][j]=1;
        image[i][j]=color;
        fill(image,check,i+1,j,color,color1);
        fill(image,check,i-1,j,color,color1);
        fill(image,check,i,j+1,color,color1);
        fill(image,check,i,j-1,color,color1);
    }
}