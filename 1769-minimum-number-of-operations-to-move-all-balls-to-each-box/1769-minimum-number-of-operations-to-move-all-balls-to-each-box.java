class Solution {
    public int[] minOperations(String boxes) {
        
        int[] preArr=new int[boxes.length()];
        int[] postArr=new int[boxes.length()];
        
        int currBalls=0;
        for(int i=1;i<boxes.length();i++){
            if(boxes.charAt(i-1)=='1'){
                ++currBalls;
            }
            preArr[i]=preArr[i-1]+currBalls;
        }
        
        currBalls=0;
        for(int i=boxes.length()-2;i>=0;i--){
            if(boxes.charAt(i+1)=='1'){
                ++currBalls;
            }
            postArr[i]=postArr[i+1]+currBalls;
        }
        
        int[] ans=new int[boxes.length()];
        for(int i=0;i<ans.length;i++){
            ans[i]=preArr[i]+postArr[i];
        }
        return ans;
    }
}