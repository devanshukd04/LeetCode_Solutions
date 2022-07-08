class Solution {
    Integer[][][] a=new Integer[100][100][21];
    final int max_cost=1000001;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int answer=findMinCost(houses,cost,target,0,0,0);
        return answer==max_cost?-1:answer;
    }
    public int findMinCost(int[] houses, int[][] cost, int targetCount, int currIndex, int neighborhoodCount, int prevHouseColor){
        if(currIndex==houses.length){
            return neighborhoodCount==targetCount?0:max_cost;
        }
        if(neighborhoodCount>targetCount){
            return max_cost;
        }
        if(a[currIndex][neighborhoodCount][prevHouseColor]!=null){
            return a[currIndex][neighborhoodCount][prevHouseColor];
        }
        int minCost=max_cost;
        if(houses[currIndex]!=0){
            int newNeighborhoodCount=neighborhoodCount+(houses[currIndex]!=prevHouseColor?1:0);
            minCost=findMinCost(houses,cost,targetCount,currIndex+1,newNeighborhoodCount,houses[currIndex]);
        }
        else{
            int totalColors=cost[0].length;
            for(int color=1;color<=totalColors;color++){
                int newNeighborhoodCount=neighborhoodCount+(color!=prevHouseColor?1:0);
                int currCost=cost[currIndex][color-1]+findMinCost(houses,cost,targetCount,currIndex+1,newNeighborhoodCount,color);
                minCost=Math.min(minCost,currCost);
            }
        }
        return a[currIndex][neighborhoodCount][prevHouseColor]=minCost;
    }
}