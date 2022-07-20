class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(String w:words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        char[] schar=s.toCharArray();
        for(String w:map.keySet()){
            char[] wchar=w.toCharArray();
            int i=0;
            int j=0;
            while(i<schar.length && j<wchar.length){
                if(schar[i]==wchar[j]){
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            }
            if(j==wchar.length){
                count+=map.get(w);
            }
        }
        return count;
    }
}