class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res=1;
        for(int i=0;i<nums.length-1;i++){
            //Calling function nums.length-1 times
            int ans=helper(nums,i);
            res=Math.max(res,ans);
        }
        return res;
    }
    public int helper(int[] nums,int a){
        int ans=0;
        //Creating a hashmap
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        //Running the forloop from a top length of array
        for(int i=a;i<nums.length;i++){
            //Accesing the number at index i
            int num=nums[i];
            //To keep track of the current bit number
            int no=0;
            ans++;
            //Running while loop till number >0
            while(num>0){
                //Doing bitwise AND of num and 1
                int bit=num&1;
                //If bit is 1, then in hashmap I will store that the the bit bumber no is set
                if(bit==1){
                    //If already bit number no is set then we cannot move further as this violates the conditiom
                    if(map.containsKey(no)){
                        return ans-1;
                    }
                    else{
                        map.put(no,i);
                    }
                }
                //Doing right shift
                num=num>>1;
                //Increamenting bit number
                no++;
            }
            
        }
        return ans;
    }
}