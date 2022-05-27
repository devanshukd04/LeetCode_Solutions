class Solution {
    public int maxArea(int[] height) {
        int sum=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int a=height[i]>height[j]?height[j]:height[i];
            a=a*(j-i);
            if(sum<a){
                sum=a;  
            }
            if(height[i]<height[j]){
                ++i;  
            }
            else{
                --j;
            }
        }
        return sum;
    }
}