//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution
{
    int[] prime;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        prime=new int[10000];
        Arrays.fill(prime,1);
        prime[1]=0;
        for(int i=2;i<=9999;i++){
            if(prime[i]==1){
                for(int j=i*i;j<=9999;j+=i){
                    prime[j]=0;
                }
            }
        }
    }
    
    public int shortestPath(int Num1,int Num2){
        // Complete this function using prime array
        int[] ans=new int[10000];
        Arrays.fill(ans,-1);
        boolean[] visited=new boolean[10000];
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(Num1);
        visited[Num1]=false;
        ans[Num1]=0;
        int[] power=new int[4];
        power[3]=1000;
        for(int i=2;i>=0;i--){
            power[i]=power[i+1]/10;
        }
        while(!queue.isEmpty()){
            int num=queue.poll();
            if(visited[num])continue;
            visited[num]=true;
            for(int i=0;i<4;i++){
                int pow=power[3-i];
                int digit=(num/pow)%10;
                for(int j=0;j<=9;j++){
                    if((i==0 && j==0) || j==digit)continue;
                    int temp=num-digit*pow+j*pow;
                    if(prime[temp]==1 && ans[temp]==-1){
                        ans[temp]=1+ans[num];
                        queue.add(temp);
                    }
                }
            }
        }
        return ans[Num2];
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        Solution ob = new Solution();
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int Num1=Integer.parseInt(input_line[0]);
            int Num2=Integer.parseInt(input_line[1]);
            System.out.println(ob.shortestPath(Num1,Num2));
        }
    }
}
// } Driver Code Ends