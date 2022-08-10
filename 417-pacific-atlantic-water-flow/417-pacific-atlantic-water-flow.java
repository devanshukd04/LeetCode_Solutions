class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(heights.length==0 || heights[0].length==0){
            return ans;
        }
        int row=heights.length;
        int col=heights[0].length;
        int[][] visited1=new int[row][col];
        int[][] visited2=new int[row][col];
        
        for(int i=0;i<row;i++){
            dfs(heights,visited1,i,0,Integer.MIN_VALUE);
            dfs(heights,visited2,i,col-1,Integer.MIN_VALUE);
        }
        for(int i=0;i<col;i++){
            dfs(heights,visited1,0,i,Integer.MIN_VALUE);
            dfs(heights,visited2,row-1,i,Integer.MIN_VALUE);
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited1[i][j]==1 && visited2[i][j]==1){
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] heights,int[][] visited,int i,int j,int prev){
        if(i<0 | i>=heights.length || j<0 || j>=heights[0].length){
            return;
        }
        if(heights[i][j]<prev || visited[i][j]==1){
            return;
        }
        visited[i][j]=1;
        dfs(heights,visited,i+1,j,heights[i][j]);
        dfs(heights,visited,i-1,j,heights[i][j]);
        dfs(heights,visited,i,j+1,heights[i][j]);
        dfs(heights,visited,i,j-1,heights[i][j]);
    }
}