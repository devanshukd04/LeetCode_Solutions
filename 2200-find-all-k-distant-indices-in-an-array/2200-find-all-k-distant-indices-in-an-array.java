class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list=new ArrayList<Integer>();
        int a=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
                for(int j=i-k;j<=i+k;j++){
                    if(j<0 || j>=nums.length){
                        a++;
                    }
                    else{
                        if(!map.containsKey(j)){
                            list.add(j);
                            map.put(j,1);
                        }
                    }
                }
            }
        }
        return list;
    }
}