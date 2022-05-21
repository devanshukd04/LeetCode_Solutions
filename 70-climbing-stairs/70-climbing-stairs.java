class Solution {
    public int climbStairs(int n) {
        HashMap<String,Integer> map =new HashMap<String,Integer>();
        int a=climbRecursion(n,0,map);
        return a;
    }
    public int climbRecursion(int n,int p,HashMap map){
        int a;
        if(p==n-1){ 
            return 1;
        }
        else if(p==n-2){
            return 2;
        }
        if(map.containsKey(p)){
            return (int)map.get(p); 
        }
        a=climbRecursion(n,p+1,map)+climbRecursion(n,p+2,map);   
        map.put(p,a);
        return a;
    }
}