class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans=new ArrayList<Integer>();
        boolean flag1=true;
        boolean flag2=true;
        HashSet<Integer> set=new HashSet<Integer>();
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            if(i>=k && i<nums.length-k){
                res.add(i);
            }
        }
        if(set.size()==1){
            return res;
        }
        for(int i=k;i<nums.length-k;i++){
            flag1=true;
            flag2=true;
            for(int j=i-k;j<i-1;j++){
                if(nums[j]-nums[j+1]<0){
                    flag1=false;
                    break;
                }
            }
            if(flag1){
                for(int j=i+1;j<i+k;j++){
                    if(nums[j]-nums[j+1]>0){
                        flag2=false;
                        break;
                    }
                }   
            }
            if(flag1 && flag2){
                ans.add(i);
            }
        }
        return ans;
    }
}