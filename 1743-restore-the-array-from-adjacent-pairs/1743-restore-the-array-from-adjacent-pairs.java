class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        
        for(int[] adjacentPair:adjacentPairs){
            if(!map.containsKey(adjacentPair[0])){
                map.put(adjacentPair[0],new ArrayList<Integer>());
            }
            if(!map.containsKey(adjacentPair[1])){
                map.put(adjacentPair[1],new ArrayList<Integer>());
            }
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        
        int start=-1;
        
        for(int key:map.keySet()){
            if(map.get(key).size()==1){
                start=key;
            }
        }
        
        int[] ans=new int[adjacentPairs.length+1];
        
        
        ans[0]=start;
        set.add(start);
        
        for(int i=1;i<ans.length;i++){
            List<Integer> list=map.get(ans[i-1]);
            for(int num:list){
                if(!set.contains(num)){
                    ans[i]=num;
                }
            }
            set.add(ans[i]);
        }
        
        return ans;
    }
}