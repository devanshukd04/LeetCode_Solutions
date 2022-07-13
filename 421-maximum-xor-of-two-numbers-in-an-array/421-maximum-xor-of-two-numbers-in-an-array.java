class Solution {
    
    class TrieNode{
            TrieNode child[]=new TrieNode[2];
        }
    
    class Trie{
        TrieNode root;
        Trie(){
            root=new TrieNode();
        }
        public void insert(int num){
            TrieNode temp=root;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                if(temp.child[bit]==null){
                    temp.child[bit]=new TrieNode();
                }
                temp=temp.child[bit];
            }
        }
        public int xor(int num){
            TrieNode temp=root;
            int ans=0;

            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                bit=1-bit;
                if(temp.child[bit]!=null){
                    temp=temp.child[bit];
                    ans=ans|(1<<i);
                }
                else{
                    temp=temp.child[1-bit];
                }
            }
            return ans;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie obj=new Trie();
        int ans=0;
        for(int a:nums){
            obj.insert(a);
        }
        for(int a:nums){
            ans=Math.max(ans,obj.xor(a));
        }
        return ans;
    }
}