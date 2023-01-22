class Solution {
    public boolean makeStringsEqual(String s, String target) {
        List<Character> list1=new ArrayList<Character>();
        List<Character> list2=new ArrayList<Character>();
        for(int i=0;i<s.length();i++){
            if(!list1.contains(s.charAt(i))){
                list1.add(s.charAt(i));
            }
        }
        for(int i=0;i<target.length();i++){
            if(!list2.contains(target.charAt(i))){
                list2.add(target.charAt(i));
            }
        }
        if(list2.size()==1){
            if(list1.size()==1 && list1.get(0)==list2.get(0)){
                return true;
            }
            if(list2.get(0)=='1'){
                if(list1.size()==1 && list1.get(0)=='0'){
                    return false;
                }
                return true;
            }
            return false;
        }
        if(list1.size()==1){
            if(list2.size()==1 && list1.get(0)==list2.get(0)){
                return true;
            }
            if(list1.get(0)=='0'){
                return false;
            }
            if(list1.get(0)=='1' && list2.size()>1){
                return true;
            }
            return false;
        }
        return true;
    }
}