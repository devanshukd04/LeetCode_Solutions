class Solution {
    public int minSetSize(int[] arr) {
        //Variable n stores the length of array
        int n=arr.length;
        //Creating a hashmap
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        //Creating a priority queue and creating customized comparator to store elements in descending order of their frequency in array
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>((a,b)->{
            int comparision=map.get(b).compareTo(map.get(a));
            return comparision;
        });
        for(int i=0;i<n;i++){
            //Updating the frequency of each element in hashmap
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int num:map.keySet()){
            //Adding the unique elements in priority queue
            queue.add(num);
        }
        //Variable count stores the number of element to be remove
        int count=0;
        //Loop continues untill size of array reduces to less than or equal to length of array
        while(n>arr.length/2){
            count++;
            //Storing the frequency of poll element from the queue
            int key=queue.poll();
            //Updating the size of array
            n-=map.get(key);
        }
        return count;
    }
}