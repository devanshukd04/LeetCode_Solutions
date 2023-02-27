/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid,0,0,grid.length-1,grid[0].length-1);
    }
    public Node helper(int[][] grid,int rowStart,int colStart,int rowEnd,int colEnd){
        if(rowStart>rowEnd || colStart>colEnd){
            return null;
        }
        boolean isLeaf=true;
        int val=grid[rowStart][colStart];
        for(int i=rowStart;i<=rowEnd;i++){
            for(int j=colStart;j<=colEnd;j++){
                if(grid[i][j]!=val){
                    isLeaf=false;
                    break;
                }
            }
        }
        if(isLeaf){
            return new Node(val==1,true,null,null,null,null);
        }
        int rowMid=(rowStart+rowEnd)/2;
        int colMid=(colStart+colEnd)/2;
        System.out.println(rowStart+" "+rowMid+" "+rowEnd);
        System.out.println(colStart+" "+colMid+" "+colEnd);
        Node topLeft=helper(grid,rowStart,colStart,rowMid,colMid);
        Node topRight=helper(grid,rowStart,colMid+1,rowMid,colEnd);
        Node bottomLeft=helper(grid,rowMid+1,colStart,rowEnd,colMid);
        Node bottomRight=helper(grid,rowMid+1,colMid+1,rowEnd,colEnd);
        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }
}