class Solution {
    public int[] sortByBits(int[] arr) {
        int[] ans=new int[arr.length];
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int temp=arr[i];
            int setBit=0;
            while(temp>0){
                if((temp&1)==1){
                    setBit++;
                }
                temp>>=1;
            }
            map.put(arr[i],setBit);
        }
        
        
        List<Integer> list=new ArrayList<>();
        
        for(int num:arr){
            list.add(num);
        }

        Collections.sort(list,(a,b)->map.get(a)!=map.get(b)?map.get(a)-map.get(b):a-b);
        
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        
        return arr;
    }
}