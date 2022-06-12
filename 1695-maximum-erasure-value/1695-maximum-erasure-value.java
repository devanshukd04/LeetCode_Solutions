class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int a1=0;
        boolean flag=true;
        int[] b=new int[nums.length];
        b[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            b[i]=b[i-1]+nums[i];
        }
        int sum=0;
        int csum;
        HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(a.containsKey(nums[i])){
                int c=a.get(nums[i]);
                csum=b[i-1]-b[a1]+nums[a1];
                sum=csum>sum?csum:sum;
                int d=a1;
                while(d<=c){
                    a.remove(nums[d]);
                    d++;
                }
                a.put(nums[i],i);
                a1=c+1;
                if(i==nums.length-1){
                    flag=false;
                }
            }
            else{
                a.put(nums[i],i);
            }
        }
        if(flag){
            csum=b[nums.length-1]-b[a1]+nums[a1];
            sum=csum>sum?csum:sum; 
        }
        return sum;
    }
}