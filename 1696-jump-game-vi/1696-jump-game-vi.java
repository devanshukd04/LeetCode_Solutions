class Solution {
    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> a=new LinkedList<Integer>();
        a.add(0);
        for(int i=1;i<nums.length;i++){
            if(a.getFirst()<i-k){
                a.removeFirst();
            }
            nums[i]+=nums[a.getFirst()];
            while(!a.isEmpty() && nums[a.getLast()]<=nums[i]){
                a.removeLast();   
            }
            a.addLast(i);
        }
        return nums[nums.length-1];
    }
}