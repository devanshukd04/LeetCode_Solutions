class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        for(int num:map.keySet()){
            queue.add(num);
        }
        while(!queue.isEmpty()){
            int count=0;
            int min=queue.peek();
            List<Integer> list=new ArrayList<Integer>();
            while(true){
                if(!map.containsKey(min)){
                    if(count<3){
                        return false;
                    }
                    break;
                }
                map.put(min,map.get(min)-1);
                ++count;
                if(map.containsKey(min+1) && map.get(min)+1>map.get(min+1)){
                    if(count<3){
                        return false;
                    }
                    break;
                }
                if(map.get(min)!=0){
                    list.add(min);
                }
                else{
                    map.remove(min);
                }
                queue.poll();
                ++min;
            }
            for(int num:list){
                queue.add(num);
            }
        }
        return true;
    }
}