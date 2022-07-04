class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> a=new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++){
            a.add(nums[i]);
        }
        int b=nums.length-k;
        while(b>0){
            a.poll();
            b--;
        }
        return a.poll();
    }
}