class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list =new ArrayList<String>();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        String s1;
        for(int i=0;i<=s.length()-10;i++){
            s1=s.substring(i,i+10);
            if(!map.containsKey(s1)){
                map.put(s1,1);
            }
            else{
                if(!list.contains(s1)){
                    list.add(s1);
                }
            }
        }
        return list;
    }
}