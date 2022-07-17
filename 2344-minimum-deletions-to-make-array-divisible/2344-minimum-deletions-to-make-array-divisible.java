class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        HashSet<Integer> set=new HashSet<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int del=0;
        for(int num:nums){
            set.add(num);
            if(map.containsKey(num)){
                int freq=map.get(num);
                map.put(num,freq+1);
            }
            else{
                map.put(num,1);
            }
        }
        List<Integer> list1=new ArrayList<Integer>();
        for(int num:set){
            list1.add(num);
        }
        set.clear();
        for(int num:numsDivide){
            set.add(num);
        }
        List<Integer> list2=new ArrayList<Integer>();
        for(int num:set){
            list2.add(num);
        }
        Collections.sort(list1);
        boolean a=true;
        for(int num1:list1){
            a=true;
            for(int num2:list2){
                if(!(num2%num1==0)){
                    a=false;
                    break;
                }
            }
            if(a){
                return del;
            }
            else{
                del+=map.get(num1);
            }
        }
        return -1;
    }
}