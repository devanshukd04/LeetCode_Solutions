class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> a=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int sum=0;
        int b,c;
        for(int i=0;i<nums.length-2;i++){
            sum=-nums[i];
            b=i+1;
            c=nums.length-1;
            while(b<c){
                if(nums[b]+nums[c]>sum){
                    c--;
                }
                else if(nums[b]+nums[c]<sum){
                    b++;
                } 
                else{
                    List<Integer> b1=new ArrayList<Integer>();
                    b1.add(nums[i]);
                    b1.add(nums[b]);
                    b1.add(nums[c]);
                    a.add(b1);
                    b++;
                    c--;
                    while(b<c && nums[b]==nums[b-1]){
                        b++;
                    }
                    while(b<c && nums[c]==nums[c+1]){
                        c--;
                    }
                }
            }
            while(i<nums.length-2 && nums[i]==nums[i+1]){
                i++;
            }
        }
        return a;
    }
}