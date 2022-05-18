class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> a=new ArrayList<String>();
        List<String> b=new ArrayList<String>();
        String d;
        for(int i=0;i<words.length;i++){
            char[] c=words[i].toCharArray();
            Arrays.sort(c);
            d=new String(c);
            if(a.size()==0 || !(a.get(a.size()-1).equals(d))){
                a.add(d);
                b.add(words[i]);
            }
        }
        return b;
    }
}