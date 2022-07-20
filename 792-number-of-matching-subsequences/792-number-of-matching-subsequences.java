class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        boolean flag;
        int count=0;
        HashMap<Character,List<Integer>> map=new HashMap<Character,List<Integer>>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                List<Integer> list=map.get(s.charAt(i));
                list.add(i);
                map.put(s.charAt(i),list);
            }
            else{
                List<Integer> list=new ArrayList<Integer>();
                list.add(i);
                map.put(s.charAt(i),list);
            }
        }
        for(int i=0;i<words.length;i++){
            String w=words[i];
            int j=0;
            String s1=s;
            flag=true;
            int index=-1;
            while(j<w.length()){
                if(map.containsKey(w.charAt(j))){
                    List<Integer> list=map.get(w.charAt(j));
                    for(int num:list){
                        if(index<num){
                            index=num;
                            flag=true;
                            break;
                        }
                        else{
                            flag=false;
                        }
                    }
                    if(!flag){
                      break;  
                    }
                }
                else{
                    flag=false;
                    break;
                }
                ++j;
            }
            if(flag){
                ++count;
            }  
        }
        return count;
    }
}