class Solution {
    public int deleteAndEarn(int[] nums) {
        List<Integer> list =new ArrayList<Integer>();
        List<Integer> list1 =new ArrayList<Integer>();
        int a,b,j;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        if(nums.length==0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                a=map.get(nums[i]);
                map.put(nums[i],a+1);
            }
            else{
                map.put(nums[i],1);
                list.add(nums[i]);
            }
        }
        a=0;
        b=0;
        j=0;
        while(j!=list.size()){
            if(j>0 && list.get(j)==list.get(j-1)+1){
                if(a+list.get(j)*map.get(list.get(j))>b){
                    list1.add(a+list.get(j)*map.get(list.get(j)));
                    a=b;
                    b=list1.get(list1.size()-1);
                }
                else{
                    list1.add(b);
                    b=b;
                    a=list1.get(list1.size()-2);
                }
            }
            else{
                list1.add(b+list.get(j)*map.get(list.get(j)));
                a=b;
                b=list1.get(list1.size()-1);
            }
            j++;
        }
        b=list1.get(list1.size()-1);
        return b;
    }
    
}