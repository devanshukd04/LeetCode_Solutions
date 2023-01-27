class Solution {
    class Trie{
        Trie[] arr;
        boolean isEnd;
        Trie(){
            this.arr=new Trie[26];
            for(int i=0;i<26;i++){
                this.arr[i]=null;
            }
            this.isEnd=false;
        }
    };
    public void insert(Trie root,String s){
        Trie node=root;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(node.arr[index]==null){
                node.arr[index]=new Trie();
            }
            node=node.arr[index];
        }
        node.isEnd=true;
    }
    public int dfs(Trie root,String s,int index){
        if(index>=s.length()){
            return 0;
        }
        Trie node=root;
        for(int i=index;i<s.length();i++){
            int index1=s.charAt(i)-'a';
            if(node.arr[index1]==null){
                return -1;
            }
            node=node.arr[index1];
            if(node.isEnd){
                int count=dfs(root,s,i+1);
                if(count!=-1){
                    return count+1;
                }
            }
        }
        return -1;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root=new Trie();
        for(String word:words){
            insert(root,word);
        }
        List<String> ans=new ArrayList<String>();
        for(String word:words){
            if(dfs(root,word,0)>1){
                ans.add(word);
            }
        }
        return ans;
    }
}