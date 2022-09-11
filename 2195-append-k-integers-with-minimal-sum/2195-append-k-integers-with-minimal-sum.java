class Solution {
    public long minimalKSum(int[] nums, int k) {
        long prev=0;
        long sum=0;
        Arrays.sort(nums);
        for(int num:nums){
            long num1=num;
            if(num!=prev+1 && num!=prev){
                if(num1-prev-1<=k){
                    sum+=num1*(num1+1)/2-prev*(prev+1)/2-num1;
                    k-=num1-prev-1;
                }
                else{
                    sum+=(prev+k)*(prev+k+1)/2-prev*(prev+1)/2;
                    k=0;
                }
            }
            prev=num1;
            if(k==0){
                return sum;
            }
        }
        sum+=(prev+k)*(prev+k+1)/2-prev*(prev+1)/2;
        return sum;
    }
}