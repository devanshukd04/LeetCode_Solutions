class Solution {
    List<List<Integer>> ans;
    HashSet<List<Integer>> set;
    public List<List<Integer>> findSubsequences(int[] nums) {
        set=new HashSet<List<Integer>>();
        ans=new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>(),0,nums,Integer.MIN_VALUE);
        return ans;
    }
    public void helper(List<Integer> list,int index,int[] nums,int prevElement){
        if(index==nums.length){
            if(list.size()>=2 &&  !set.contains(list)){
                List<Integer> arr=new ArrayList<Integer>(list);
                ans.add(arr);
                set.add(arr);
            }
            return;
        }
        //notTake
        helper(list,index+1,nums,prevElement);
        if(nums[index]>=prevElement){
            //take
            list.add(nums[index]);
            helper(list,index+1,nums,nums[index]);
            list.remove(list.size()-1);
        }
        return;
    }
}