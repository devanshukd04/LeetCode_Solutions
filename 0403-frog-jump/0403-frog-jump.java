class Solution {
    public boolean canCross(int[] stones) {
        int[][] dp=new int[2001][2001];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        for(int[] arr:dp){
            Arrays.fill(arr,-1);   
        }
        if(!map.containsKey(1)){
            return false;
        }
        return helper(stones,dp,map,1,1);
    }
    public boolean helper(int[] stones, int[][] dp, Map<Integer,Integer> map, int index,int prevJump){
        if(index>=stones.length){
            return false;
        }
        if(index==stones.length-1){
            return true;
        }
        if(dp[index][prevJump]!=-1){
            return dp[index][prevJump]==1?true:false;
        }
        boolean ans=false;
        for(int nextJump=prevJump-1;nextJump<=prevJump+1;nextJump++){
            if(nextJump>0 && map.containsKey(stones[index]+nextJump)){
                if(helper(stones,dp,map,map.get(stones[index]+nextJump),nextJump)){
                    dp[index][prevJump]=1;
                    return true;
                }
            }
        }
        dp[index][prevJump]=0;
        return false;
    }
}