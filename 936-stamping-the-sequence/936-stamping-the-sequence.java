class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int m=stamp.length();
        int n=target.length();
        Queue<Integer> queue=new ArrayDeque();
        boolean[] done=new boolean[n];
        Stack<Integer> ans=new Stack();
        List<Node> A=new ArrayList();
        
        for(int i=0;i<=n-m;++i){
            Set<Integer> made=new HashSet();
            Set<Integer> todo=new HashSet();
            for(int j=0;j<m;++j){
                if(target.charAt(i+j)==stamp.charAt(j)){
                    made.add(i+j);
                }
                else{
                    todo.add(i+j);
                }
            }
            A.add(new Node(made,todo));
            
            if(todo.isEmpty()){
                ans.push(i);
                for(int j=i;j<i+m;++j){
                    if(!done[j]){
                        queue.add(j);
                        done[j]=true;
                    }
                }
            }
        }
            
        while(!queue.isEmpty()){
            int i=queue.poll();
            for(int j=Math.max(0,i-m+1);j<=Math.min(n-m,i);++j){
                if(A.get(j).todo.contains(i)){
                    A.get(j).todo.remove(i);
                    if(A.get(j).todo.isEmpty()){
                        ans.push(j);
                        for(int M:A.get(j).made){
                            if(!done[M]){
                                queue.add(M);
                                done[M]=true;
                            }
                        }
                    }
                }
            }
        }
        for(boolean b:done){
            if(!b){
                return new int[0];
            }
        }
        int[] ret=new int[ans.size()];
        int t=0;
        while(!ans.isEmpty()){
            ret[t++]=ans.pop();
        }
        return ret;
    }
}
class Node{
    Set<Integer> made,todo;
    Node (Set<Integer> m,Set<Integer> t){
        made=m;
        todo=t;
    }
}