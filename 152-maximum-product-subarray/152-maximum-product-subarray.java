class Solution {
    public int maxProduct(int[] nums) {
        int[] array=new int[nums.length];
        int[] array1=new int[nums.length];
        array[0]=nums[0];
        array1[0]=nums[0];
        int max=array[0];
        int min=0;
        int b;
        for(int i=1;i<nums.length;i++){
            array[i]=nums[i]*array[i-1];
            array1[i]=nums[i]*array1[i-1];
            if(array[i]<=0){
                array[i]=nums[i];
            }
            if(array1[i]==0){
                array1[i]=nums[i];
            }
            if(max<array[i] || max<array1[i]){
                max=array[i]>array1[i]?array[i]:array1[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(array1[min]>array1[i]){
                min=i;
            }
        }
        if(array1[min]==0){
            return max;
        }
        else{
            b=max;
           for(int i=0;i<min;i++){
                if(array1[i]!=0){
                    int a=array1[min]/array1[i];
                    if(max<a){
                        max=a;
                    }
                }
               else{
                   max=b;
               }
           }
        }
        return max;
    }
}