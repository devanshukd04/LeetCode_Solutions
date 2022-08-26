class Solution {
    public boolean reorderedPowerOf2(int n) {
        String s=Integer.toString(n);
        StringBuffer ans=new StringBuffer();
        int[] visited=new int[s.length()];
        return permutation(ans,0,s,visited);
    }
    public boolean powerOfTwo(String s){
        int ans=Integer.valueOf(s);
        while(ans>0){
            if((ans&1)==1 && ans>1){
                return false;
            }
            ans=ans>>1;
        }
        return true;
    }
    public boolean permutation(StringBuffer ans,int i,String s,int[] visited){
        if(i==s.length()){
            return powerOfTwo(ans.toString());
        }
        if(i==0){
            for(int j=0;j<s.length();j++){
                if(visited[j]!=1 && s.charAt(j)!='0'){
                    ans.append(s.charAt(j));
                    visited[j]=1;
                    if(permutation(ans,i+1,s,visited)){
                        return true;
                    }
                    ans.deleteCharAt(i);
                    visited[j]=0;
                }
            }
        }
        else{
            for(int j=0;j<s.length();j++){
                if(visited[j]!=1){
                    ans.append(s.charAt(j));
                    visited[j]=1;
                    if(permutation(ans,i+1,s,visited)){
                        return true;
                    }
                    ans.deleteCharAt(i);
                    visited[j]=0;
                }
            }
        }
        return false;
    }
}