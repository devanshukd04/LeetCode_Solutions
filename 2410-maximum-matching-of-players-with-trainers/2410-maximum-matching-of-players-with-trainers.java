class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0;
        int ans=0;
        for(int num:players){
            while(i<trainers.length && trainers[i]<num){
                i++;
            }
            if(i==trainers.length){
                break;
            }
            else{
                ans++;
            }
            i++;
        }
        return ans;
    }
}