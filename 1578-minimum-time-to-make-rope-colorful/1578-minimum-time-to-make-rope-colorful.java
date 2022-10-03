class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0;
        char prev=colors.charAt(0);
        int prevValue=neededTime[0];
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==prev){
                ans+=neededTime[i]>prevValue?prevValue:neededTime[i];
                prevValue=neededTime[i]>prevValue?neededTime[i]:prevValue;
            }
            else{
                prev=colors.charAt(i);
                prevValue=neededTime[i];
            }
        }
        return ans;
    }
}