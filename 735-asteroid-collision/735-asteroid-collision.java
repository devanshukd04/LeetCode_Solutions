class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<asteroids.length;i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
            }
            else{
                if(asteroids[i]<0){
                    if(stack.peek()>0){
                        boolean flag=true;
                        int peek=asteroids[i];
                        while(!stack.isEmpty() && peek<0 && stack.peek()>0){
                            int pop=stack.pop();
                            if(Math.abs(peek)<pop){
                                stack.push(pop);
                                flag=false;
                                break;
                            }
                            else if(Math.abs(peek)==pop){
                                flag=false;
                                break;
                            }
                        }
                        if((flag && stack.isEmpty()) || (!stack.isEmpty() && stack.peek()<0 && flag)){
                            stack.push(peek);
                        }
                    }
                    else{
                        stack.push(asteroids[i]);
                    }
                }
                else{
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] res=new int[stack.size()];
        int j=0;
        while(!stack.isEmpty()){
            res[j++]=stack.pop();
        }
        for(int i=0;i<res.length/2;i++){
            int temp=res[i];
            res[i]=res[res.length-1-i];
            res[res.length-1-i]=temp;
        }
        return res;
    }
}