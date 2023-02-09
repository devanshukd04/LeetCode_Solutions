class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] set=new HashSet[26];
        for(int i=0;i<26;i++){
            set[i]=new HashSet<String>();
        }
        for(String idea:ideas){
           set[idea.charAt(0)-'a'].add(idea.substring(1));
        }
        long ans=0;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                long mutual=0;
                for(String idea:set[i]){
                    if(set[j].contains(idea)){
                        mutual++;
                    }
                }
                ans+=2*(set[i].size()-mutual)*(set[j].size()-mutual);
            }
        }
        return ans;
    }
}