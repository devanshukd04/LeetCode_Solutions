class Solution {
    HashMap<Character,Integer> map;
    class Sortbyorder implements Comparator<String> {
        public int compare(String a, String b)
        {
            int i=0;
            int j=0;
            while(i<a.length() && j<b.length()){
                if(map.get(a.charAt(i))<map.get(b.charAt(j))){
                    return -1;
                }
                else if(map.get(a.charAt(i))>map.get(b.charAt(i))){
                    return 1;
                }
                i++;
                j++;
            }
            if(i<a.length()){
                return 1;
            }
            else if(j<b.length()){
                return -1;
            }
            return 0;
        }
    }
    public boolean isAlienSorted(String[] words, String order) {
        map=new HashMap<Character,Integer>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        String[] word=words.clone();
        Arrays.sort(words,new Sortbyorder());
        for(int i=0;i<words.length;i++){
            if(!word[i].equals(words[i])){
                return false;
            }
        }
        return true;
    }
}