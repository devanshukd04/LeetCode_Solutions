class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] dp=new Integer[piles.size()+1][k+1];
        return helper(dp,piles,piles.size()-1,k);
    }
    public int  helper(Integer[][] dp,List<List<Integer>> piles,int pile,int pileRemaining){
        if(pile<0 || pileRemaining==0){
            return 0;
        }
        if(dp[pile][pileRemaining]!=null){
            return dp[pile][pileRemaining];
        }
        int coinsPickLeft=Math.min(pileRemaining,piles.get(pile).size());
        int excludePile=helper(dp,piles,pile-1,pileRemaining);
        int includePile=0;
        int sum=0;
        for(int i=0;i<coinsPickLeft;i++){
            sum+=piles.get(pile).get(i);
            includePile=Math.max(includePile,sum+helper(dp,piles,pile-1,pileRemaining-(i+1)));
        }
        return dp[pile][pileRemaining]=Math.max(includePile,excludePile);
    }
}