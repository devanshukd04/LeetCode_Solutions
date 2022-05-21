class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int a, count=0,diff=0;
        int c;
        boolean stat=true;
        int k,i=0;
        a=-1;
        c=0;
        k=i;
        if(nums.length<=2){
            return 0;
        }
        while(i<nums.length-2){
            k=i;
            diff=nums[i+1]-nums[i];
            while(k<nums.length){
                stat=true;
                for(int j=k;j<nums.length-1;j++){
                    a++;
                    c=j+1;
                    if(diff==(nums[j+1]-nums[j])){
                        if(a>=1){
                            count++;
                            break;
                        }
                    }
                    else{
                        stat=false;
                        break;
                    }
                }
                if((!stat) || (c==nums.length-1)){
                    i+=1;
                    a=-1;
                    break;
                }
                else {
                    k=c;
                }
            }
        }
        return count;
    }
}