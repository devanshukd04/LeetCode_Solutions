class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        List<Integer> list=new ArrayList<Integer>();
        for(int num:tasks){
            if(map.containsKey(num)){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            else{
                map.put(num,1);
                list.add(num);
            }
        }
        int count=0;
        for(int num:list){
            int freq=map.get(num);
            if(freq<2){
                return -1;
            }
            int three,two;
            if(freq%3==1){
                three=freq/3>0?freq/3-1:0;
                two=(freq-three*3)/2;
            }
            else{
                three=freq/3;
                two=(freq%3)/2;
            }
            count+=three+two;
        }
        return count;
    }
}