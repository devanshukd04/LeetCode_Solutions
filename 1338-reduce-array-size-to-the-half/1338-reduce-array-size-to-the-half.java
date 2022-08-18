class Solution {
    public int minSetSize(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>((a,b)->{
            int comparision=map.get(b).compareTo(map.get(a));
            return comparision;
        });
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int num:map.keySet()){
            queue.add(num);
        }
        int count=0;
        while(n>arr.length/2){
            count++;
            int key=queue.poll();
            n-=map.get(key);
        }
        return count;
    }
}