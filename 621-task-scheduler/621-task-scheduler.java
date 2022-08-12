class Solution {
    public int leastInterval(char[] tasks, int n) {
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(Collections.reverseOrder());
        queue.addAll(map.values());
        
        while(!queue.isEmpty()){
            int time=0;
            List<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<n+1;i++){
                if(!queue.isEmpty()){
                    temp.add(queue.remove()-1);
                    time++;
                }
            }
            for(int t:temp){
                if(t>0){
                    queue.add(t);
                }
            }
            ans+=queue.isEmpty()?time:n+1;
        }
        
        return ans;
    }
}