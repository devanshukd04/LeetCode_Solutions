class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(String a,String b)->a.length()-b.length());
        HashMap<String,Integer> c=new HashMap<String,Integer>();
        int max=1;
        for(String word:words){
            int currlength=1;
            StringBuilder s=new StringBuilder(word);
            for(int i=0;i<word.length();i++){
                s.deleteCharAt(i);
                String prevWord=s.toString();
                currlength=Math.max(currlength,c.getOrDefault(prevWord,0)+1);
                s.insert(i,word.charAt(i));
            }
            c.put(word,currlength);
            max=Math.max(max,currlength);
        }
        return max;
    }
}