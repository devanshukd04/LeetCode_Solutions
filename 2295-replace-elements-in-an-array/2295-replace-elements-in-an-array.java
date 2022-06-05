class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> b=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            b.put(nums[i],i);
        }
        for(int i=0;i<operations.length;i++){
            int b1=b.get(operations[i][0]);
            b.remove(operations[i][0]);
            nums[b1]=operations[i][1];
            b.put(operations[i][1],b1);
        }
        return nums;
    }
}