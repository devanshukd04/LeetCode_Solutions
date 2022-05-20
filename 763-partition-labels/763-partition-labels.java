class Solution {
    public List<Integer> partitionLabels(String s) {
        int a=-1;
        List<Integer> list =new ArrayList<Integer>();
        String s1="";
        for(int i=0;i<s.length();i++){
            if(s1.isEmpty()){
                s1+=Character.toString(s.charAt(i));
                a=s.lastIndexOf(s.charAt(i));
                if(a==i){
                    list.add(s1.length());
                    s1="";
                }
            }
            else if(a==i){
                list.add(s1.length()+1);
                s1="";
            }
            else{
                if(s.lastIndexOf(s.charAt(i))>a){
                    a=s.lastIndexOf(s.charAt(i));
                    s1+=Character.toString(s.charAt(i));
                }
                else{
                    s1+=Character.toString(s.charAt(i));
                }
            }
        }
        return list;
    }
}