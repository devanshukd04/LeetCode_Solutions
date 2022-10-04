class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        HashMap<Integer,Integer> freq=new HashMap<Integer,Integer>();
        for(int i=0;i<word.length();i++){
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        }
        for(int frequency:map.values()){
            freq.put(frequency,freq.getOrDefault(frequency,0)+1);
            if(freq.size()==3){
                return false;
            }
        }
        if(freq.size()==1 && map.size()==1){
            return true;
        }
        if(freq.size()==1){
            return freq.containsKey(1)?true:false;   
        }
        Set<Integer> set=freq.keySet();
        List<Integer> list=new ArrayList<Integer>();
        list.addAll(set);
        if(list.get(0)==1 || list.get(1)==1){
            if(freq.get(list.get(0))==1 && list.get(0)==1){
                return true;
            }
            else if(freq.get(list.get(1))==1 && list.get(1)==1){
                return true;
            }
        }
        if(list.get(0)-list.get(1)==1){
            if(freq.get(list.get(0))==1){
                return true;
            }
            else{
                return false;
            }
        }
        else if(list.get(1)-list.get(0)==1){
            if(freq.get(list.get(1))==1){
                return true;
            }
            else{
                return false;
            }
        }
        else if(list.get(0)==1 || list.get(1)==1){
            if(freq.get(list.get(0))==1 && list.get(0)==1){
                return true;
            }
            else if(freq.get(list.get(1))==1 && list.get(1)==1){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}