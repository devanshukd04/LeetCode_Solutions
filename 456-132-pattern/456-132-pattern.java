class Solution {
    public boolean find132pattern(int[] nums) {
        int[] b=new int[nums.length];
        Stack<Integer> a=new Stack<Integer>();
        int c,d;
        b[0]=nums[0];
        for(int i=1;i<nums.length-1;i++){
            b[i]=Math.min(nums[i],b[i-1]);
        }
        a.push(nums[nums.length-1]);
        for(int i=nums.length-2;i>0;i--){
            if(nums[i]>b[i]){
                while(!a.empty() && a.peek()<=b[i]){
                    a.pop();
                }
                if(!a.empty() && a.peek()<nums[i] && a.peek()>b[i]){
                    return true;
                }
                a.push(nums[i]);
            }
        }
        return false;
    }
}