class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr,new HashSet<Character>(),0,0);
    }
    public int helper(List<String> arr,HashSet<Character> set,int index,int ans){
        if(index==arr.size()){
            return ans;
        }
        HashSet<Character> set1=new HashSet<Character>();
        String word=arr.get(index);
        boolean flag=true;
        int take=0;
        int notTake=0;
        for(int i=0;i<word.length();i++){
            if(set.contains(word.charAt(i)) || set1.contains(word.charAt(i))){
                flag=false;
                break;
            }
            else{
                set1.add(word.charAt(i));
            }
        }
        notTake=helper(arr,set,index+1,ans);
        if(flag){
            for(int i=0;i<word.length();i++){
                set.add(word.charAt(i));
            }
            take=helper(arr,set,index+1,ans+word.length());
            for(int i=0;i<word.length();i++){
                set.remove(word.charAt(i));
            }
        }
        return Math.max(take,notTake);
    }
}