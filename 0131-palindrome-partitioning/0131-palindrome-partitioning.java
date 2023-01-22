class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        this.ans=new ArrayList<List<String>>();
        helper(s,0,new ArrayList<String>());
        return this.ans;
    }
    public void helper(String s,int index,List<String> list){
        if(index==s.length()){
            this.ans.add(new ArrayList<String>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(checkPalindrome(s,index,i)){
                String s1=s.substring(index,i+1);
                list.add(s1);
                helper(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
        return;
    }
    public boolean checkPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}