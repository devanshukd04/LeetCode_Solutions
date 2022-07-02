class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s1=new Stack<Integer>();
        int a=popped[0];
        int j=0;
        for(int i=0;i<pushed.length;i++){
            s1.push(pushed[i]);
            while(!s1.isEmpty() && s1.peek()==popped[j] && j<popped.length){
                s1.pop();
                ++j;
            }
        }
        if(s1.isEmpty()){
            return true;
        }
        return false;
    }
}