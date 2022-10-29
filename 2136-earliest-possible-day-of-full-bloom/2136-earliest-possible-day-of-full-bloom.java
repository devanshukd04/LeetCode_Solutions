class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int result=0;
        List<Integer> indices=new ArrayList<Integer>();
        for(int i=0;i<growTime.length;i++){
            indices.add(i);
        }
        Collections.sort(indices,Comparator.comparingInt(i->-growTime[i]));
        for(int i=0,curPlantTime=0;i<growTime.length;i++){
            int idx=indices.get(i);
            int time=curPlantTime+plantTime[idx]+growTime[idx];
            result=Math.max(result,time);
            curPlantTime+=plantTime[idx];
        }
        return result;
    }
}