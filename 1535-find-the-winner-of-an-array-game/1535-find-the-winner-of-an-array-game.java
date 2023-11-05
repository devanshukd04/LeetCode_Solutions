class Solution {
    public int getWinner(int[] arr, int k) {
        int max=arr[0];
        for(int num:arr){
            max=max<num?num:max;
        }
        
        if(k>arr.length){
            return max;
        }
        
        Queue<Integer> queue=new LinkedList<Integer>();
        
        for(int num:arr){
            queue.add(num);
        }
        
        int freq=0;
        
        while(true){
            int element1=queue.poll();
            
            while(freq<k && queue.peek()<element1){
                queue.add(queue.poll());
                ++freq;
            }
            
            if(freq==k){
                return element1;
            }
            freq=1;
            queue.add(element1);
        }
        
    }
}