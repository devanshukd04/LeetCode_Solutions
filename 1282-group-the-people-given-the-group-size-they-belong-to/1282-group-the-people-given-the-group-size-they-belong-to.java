class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> groupMap=new HashMap<Integer,List<Integer>>();
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<groupSizes.length;i++){
            if(!groupMap.containsKey(groupSizes[i])){
                groupMap.put(groupSizes[i],new ArrayList<Integer>());
            }
            groupMap.get(groupSizes[i]).add(i);
        }
        for(int groupSize:groupMap.keySet()){
            List<Integer> availablePep=groupMap.get(groupSize);
            int totalList=availablePep.size()/groupSize;
                
            int index=0;
            
            for(int i=0;i<totalList;i++){
                List<Integer> list=new ArrayList<Integer>();
                for(int j=0;j<groupSize;j++){
                    list.add(availablePep.get(index++));
                }
                ans.add(list);
            }
                
        }
        return ans;
    }
}