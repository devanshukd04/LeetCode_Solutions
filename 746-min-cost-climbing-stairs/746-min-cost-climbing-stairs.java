class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
        int a=minCost(cost,0,0,map);
        return a;
    }
    public int minCost(int[] cost, int i, int sum,HashMap map){
        int a,b,c;
        if(map.containsKey(i)){
            return (int)map.get(i);
        }
        if(i>=cost.length){
            return sum;
        } 
        if(i==0){
            a=minCost(cost,i+1,0,map);
            b=minCost(cost,i+2,0,map);
            c=minCost(cost,i+1,0,map);  
            if(a<b && (a+cost[i])<c){
                return cost[i]+a;
            }
            else if(b<a && (b+cost[i])<c){
                return cost[i]+b;
            } 
            else{
                return c; 
            }
        }
        else{
            sum+=cost[i];
            a=minCost(cost,i+1,0,map);
            b=minCost(cost,i+2,0,map);   
        }
        if(a<b){
            map.put(i,sum+a);
            return sum+a;
        }
        else{
            map.put(i,sum+b);
            return sum+b;
        } 
        
    }
}