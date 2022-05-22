class Solution {
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list2=new ArrayList<Integer>();
        getSubsets(list2,nums,0);
        return list;
    }
    void getSubsets(List<Integer> list2,int[] nums,int count){
        if(count==nums.length){
            list.add(list2);
            return;
        }
        else{
            List<Integer> list1=new ArrayList<Integer>();
            list1.addAll(list2);
            getSubsets(list2,nums,count+1);
            list1.add(nums[count]);
            getSubsets(list1,nums,count+1);
        }
        return;
    }
}