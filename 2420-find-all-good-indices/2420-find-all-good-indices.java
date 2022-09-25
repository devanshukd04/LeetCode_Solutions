class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans=new ArrayList<Integer>();
        boolean flag1=true;
        boolean flag2=true;
        //If all elements are equal the return nums.length-2*k 
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
            //Check if index-k upto index is non-increasing
            for(int j=i-k;j<i-1;j++){
                if(nums[j]-nums[j+1]<0){
                    flag1=false;
                    break;
                }
            }
            //Check if index upto index+k is non-decreasing
            if(flag1){
                for(int j=i+1;j<i+k;j++){
                    if(nums[j]-nums[j+1]>0){
                        flag2=false;
                        break;
                    }
                }   
            }
            //If condition satisfis then add the index in list
            if(flag1 && flag2){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean helper1(int[] nums,int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]-nums[i+1]<0){
                return false;
            }
        }
        return true;
    }
    public boolean helper2(int[] nums,int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]-nums[i+1]>0){
                return false;
            }
        }
        return true;
    }
}