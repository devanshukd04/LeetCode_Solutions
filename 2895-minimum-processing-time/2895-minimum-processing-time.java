class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks,Collections.reverseOrder());
        
        int ans=0;
        int index=0;
        
        for(int i=0;i<tasks.size();i+=4){
            ans=Math.max(ans,processorTime.get(index++)+tasks.get(i));
        }
        
        return ans;
    }
}