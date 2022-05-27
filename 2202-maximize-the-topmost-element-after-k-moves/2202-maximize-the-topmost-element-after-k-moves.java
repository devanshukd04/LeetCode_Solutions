class Solution {
    public int maximumTop(int[] nums, int k) {
        List<Integer> list =new ArrayList<Integer>();
        int a;
        boolean stat=false;
        if(nums.length==1){
            if(k%2==0){
                return nums[0];
            }
            else{
                return -1;
            }
        }
        if(nums.length==0){
            return -1;
        }
        if(k==0){
            return nums[0];
        }
        if(k==1){
            return nums[1];
        }
        if(k>nums.length){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        if(nums.length==0){
            return -1;
        }
        for(int i=0;i<k-1;i++){
            if(i==nums.length-1){
                stat=true;
                break;
            }
            list.add(nums[i]);
        }
        Collections.sort(list);
        a=list.size()-1;
        if(stat){
            return list.get(a);
        }
        if(k<=nums.length-1 && nums[k]>list.get(a)){
            return nums[k];
        }
        return list.get(a);
    }
}