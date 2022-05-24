class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> a2=new ArrayList<List<Integer>>();
        int target1;
        int a;
        int b;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                target1=target-nums[i]-nums[j];
                a=j+1;
                b=nums.length-1;
                while(a<b){
                    if(nums[a]+nums[b]==target1){
                        List<Integer> a1=new ArrayList<Integer>();
                        a1.add(nums[i]);
                        a1.add(nums[j]);
                        a1.add(nums[a]);
                        a1.add(nums[b]);
                        if(!a2.contains(a1)){
                            a2.add(a1);
                        }
                        while(a<b && nums[a]==a1.get(2)){
                            a++;
                        }
                        while(a<b && nums[b]==a1.get(3)){
                            b--;
                        }
                    }
                    else if(nums[a]+nums[b]>target1){
                        b--;
                    }
                    else{
                        a++;
                    }
                }
                while(j<nums.length-1 && nums[j+1]==nums[j]){
                    j++;
                }
            }
            while(i<nums.length-1 && nums[i+1]==nums[i]){
                i++;
            }
        }
        return a2;
    }
}