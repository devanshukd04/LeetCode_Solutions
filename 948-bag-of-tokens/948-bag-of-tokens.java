class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int i=0;
        int j=tokens.length-1;
        Arrays.sort(tokens);
        int ans=0;
        int score=0;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i];
                i++;
                score+=1;
            }
            else{
                if(score>=1){
                    power+=tokens[j];
                    j--;
                    score-=1;
                }
                else{
                    return score;
                }
            }
            ans=Math.max(ans,score);
        }
        return ans;
    }
}