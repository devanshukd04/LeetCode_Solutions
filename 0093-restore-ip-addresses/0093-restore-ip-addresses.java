class Solution {
    List<String> list;
    HashSet<String> set;
    public List<String> restoreIpAddresses(String s) {
        list=new ArrayList<String>();
        set=new HashSet<String>();
        helper(s,0,new StringBuffer(),-1,3);
        return list;
    }
    public void helper(String s,int index,StringBuffer ans,int num,int dot){
        if(index==s.length()){
            if(dot==0 && num!=-1){
                list.add(ans.toString());
            }
            return;
        }
        if(dot==0){
            if((s.charAt(index)=='0' && index!=s.length()-1) || (s.length()-index)>3){
                return;
            }
            String sub=s.substring(index);
            System.out.println(sub);
            if(Integer.valueOf(sub)<=255){
                int i=ans.length();
                ans.append(sub);
                String res=ans.toString();
                if(!set.contains(res)){
                    list.add(res);
                    set.add(res);
                }
                ans.delete(i,ans.length());
            }
            return;
        }
        //notTake
        char c=s.charAt(index);
        int digit=c-'0';
        if(num!=-1 && (num*10+digit)>255){
            ans.append('.');
            helper(s,index,ans,-1,dot-1);
            ans.deleteCharAt(ans.length()-1);
        }
        if(num!=-1){
            ans.append('.');
            helper(s,index,ans,-1,dot-1);
            ans.deleteCharAt(ans.length()-1);
        }
        //take
        if(num!=-1 && (num*10+digit)<=255 && num!=0){
            ans.append(s.charAt(index));
            helper(s,index+1,ans,num*10+digit,dot);
            ans.deleteCharAt(ans.length()-1);
        }
        if(num==-1){
            ans.append(s.charAt(index));
            helper(s,index+1,ans,digit,dot);
            ans.deleteCharAt(ans.length()-1);
        }
    }
}