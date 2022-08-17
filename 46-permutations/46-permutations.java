class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> list1=new ArrayList<Integer>();
        HashSet<Integer> set=new HashSet<Integer>();
        permutation(ans,list1,nums,set);
        return ans;
    }
    public void permutation(List<List<Integer>> list, List<Integer> list1,int[] nums,HashSet<Integer> set){
        if(list1.size()==nums.length){
            List<Integer> list2=new ArrayList<Integer>();
            list2.addAll(list1);
            list.add(list2);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                list1.add(nums[i]);
                set.add(nums[i]);
                permutation(list,list1,nums,set);
                list1.remove(list1.size()-1);
                set.remove(nums[i]);
            }
        }
    }
}