class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        boolean stat=false;
        int sum=0;
        int j=-1,k=-1;
        int[] a1=new int[height.length];
        a1[0]=-1;
        int[] a2=new int[height.length];
        a2[height.length-1]=-1;
        for(int i=0;i<height.length;i++){
            stat=true;
            if(s.isEmpty()){
                s.push(i);
            }
            else{
                if(height[s.peek()]>height[i]){
                    a1[i]=s.peek();
                    s.push(s.peek());
                }
                else{
                    while(!s.isEmpty()){
                        if(height[s.peek()]>height[i]){
                            a1[i]=s.peek();
                            s.push(i);
                            stat=false;
                            break;
                        }
                        s.pop();
                    }
                    if(stat){
                        s.push(i);
                        a1[i]=-1;
                    }
                }
            }
        }
        while(!s.isEmpty()){
            s.pop();
            }
        for(int i=height.length-1;i>=0;i--){
            stat=true;
            if(s.isEmpty()){
                s.push(i);
            }
            else{
                if(height[s.peek()]>height[i]){
                    a2[i]=s.peek();
                    s.push(s.peek());
                }
                else{
                    while(!s.isEmpty()){
                        if(height[s.peek()]>height[i]){
                            a2[i]=s.peek();
                            s.push(i);
                            stat=false;
                            break;
                        }
                        s.pop();
                    }
                    if(stat){
                        s.push(i);
                        a2[i]=-1;
                    }
                }
            }
        }
        for(int i=1;i<=height.length-2;i++){
            if((a1[i]!=-1 && a2[i]!=-1)){
                    int a=height[a2[i]]>height[a1[i]]?height[a1[i]]:height[a2[i]];
                    a=a-height[i];
                    sum+=a;
            }
        }
        return sum;
    }
}



//More Optimized Solution

// int[] left=new int[height.length];
// int[] right=new int[height.length];
// int ans=0;
// left[0]=Integer.MIN_VALUE;
// for(int i=1;i<height.length;i++){
//     left[i]=Math.max(left[i-1],height[i-1]);
// }
// right[height.length-1]=Integer.MIN_VALUE;
// for(int i=height.length-2;i>=0;i--){
//     right[i]=Math.max(right[i+1],height[i+1]);
// }
// for(int i=1;i<height.length-1;i++){
//     int curr=Math.min(left[i],right[i])-height[i];
//     ans+=curr>0?curr:0;
// }
// return ans;
