class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            if(temp==k){
                ans++;
            }
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>=k){
                    temp=gcd(nums[j],temp);
                    if(temp==k){
                        ans++;
                    }
                }
                else{
                    break;
                }
            }
        }
    return ans;
    }
    public static int gcd(int a, int b){ 
        return b==0?a:gcd(b,a%b);     
    } 
}