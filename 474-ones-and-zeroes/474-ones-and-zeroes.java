class Solution {
    HashMap<String,List<Integer>> a1=new HashMap<String,List<Integer>>();
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int a,b,d;
        dp=new int[m+1][n+1][strs.length];
        for(int i=0;i<strs.length;i++){
            a=0;
            b=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0'){
                    a++;
                }
                else{
                    b++;
                }
            }
            List<Integer> c=new ArrayList<Integer>();
            c.add(a);
            c.add(b);
            a1.put(strs[i],c);
        }
        d=helper(strs,m,n,0);
        return d;
    }
    public int helper(String [] strs, int a,int b, int i){
        int d1=0;
        int d2=0;
        if(a+b==0 || i==strs.length){
            return 0;
        }
        if(dp[a][b][i]>0){
            return dp[a][b][i];
        }
        List<Integer> a2=a1.get(strs[i]);
        if(a>=a2.get(0) && b>=a2.get(1)){
            d1=1+helper(strs,a-a2.get(0),b-a2.get(1),i+1);
        }
        d2=helper(strs,a,b,i+1);
        dp[a][b][i]=Math.max(d1,d2);
        return dp[a][b][i];
    }
}