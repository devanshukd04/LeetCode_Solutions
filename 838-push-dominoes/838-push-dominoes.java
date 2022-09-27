class Solution {
    public String pushDominoes(String dominoes) {
        char[] ans=new char[dominoes.length()];
        int j=0;
        boolean b=true;
        for(int i=0;i<dominoes.length();i++){
            if(dominoes.charAt(i)=='.'){
                ans[i]='.';
            }
            if(dominoes.charAt(i)=='L'){
                j=i;
                while(j>=0 && dominoes.charAt(j)!='R' && (i==j || dominoes.charAt(j)!='L') && b){
                    ans[j]='L';
                    j--;
                }
                b=true;
            }
            if(dominoes.charAt(i)=='R'){
                b=false;
                j=i;
                int a=0;
                while(j<dominoes.length() && dominoes.charAt(j)!='L' && (i==j || dominoes.charAt(j)!='R')){
                    ans[j]='R';
                    j++;
                    a++;
                }
                a--;
                if(j==dominoes.length()){
                    return new String(ans);
                }
                if(dominoes.charAt(j)!='R'){
                    b=true;
                    if(a%2!=0){
                        a=a/2+1;
                        ans[i+a]='.';
                    }
                    else{
                        a=a/2;
                    }
                    a++;
                    while(i+a<=j){
                        ans[i+a]='L';
                        a++;
                    }
                    i=j;
                }
                else{
                    i=j-1;
                }
                
            }
        }
        return new String(ans);
    }
}