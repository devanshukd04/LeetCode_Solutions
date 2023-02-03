//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int i=0;
        int j=0;
        String direction="right";
        int tempX=0;
        int tempY=0;
        while(i>=0 && i<arr.length && j>=0 && j<arr[0].length){
            tempX=i;
            tempY=j;
            if(arr[i][j]==0){
                if(direction=="up"){
                    i--;
                }
                else if(direction=="right"){
                    j++;
                }
                else if(direction=="down"){
                    i++;
                }
                else{
                    j--;
                }
            }
            else{
                arr[i][j]=0;
                if(direction=="up"){
                    direction="right";
                    j++;
                }
                else if(direction=="right"){
                    direction="down";
                    i++;
                }
                else if(direction=="down"){
                    direction="left";
                    j--;
                }
                else{
                    direction="up";
                    i--;
                }
            }
        }
        i=tempX;
        j=tempY;
        return new int[]{i,j};
    }
}