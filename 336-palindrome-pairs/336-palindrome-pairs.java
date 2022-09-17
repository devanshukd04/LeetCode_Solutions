class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        Set<Integer> set=new TreeSet<Integer>();
        int n=words.length;
        for(int i=0;i<n;i++){
            map.put(words[i],i);
            set.add(words[i].length());
        }
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            int length=words[i].length();
            if(length==1){
                if(map.containsKey("")){
                    ans.add(Arrays.asList(i,map.get("")));
                    ans.add(Arrays.asList(map.get(""),i));
                }
                continue;
            }
            String reverse=new StringBuilder(words[i]).reverse().toString();
            if(map.containsKey(reverse) && map.get(reverse)!=i){
                ans.add(Arrays.asList(i,map.get(reverse)));
            }
            for(Integer k:set){
                if(k==length){
                    break;
                }
                if(helper(reverse,0,length-1-k)){
                    String s1=reverse.substring(length-k);
                    if(map.containsKey(s1)){
                        ans.add(Arrays.asList(i,map.get(s1)));
                    }
                }
                if(helper(reverse,k,length-1)){
                    String s2=reverse.substring(0,k);
                    if(map.containsKey(s2)){
                        ans.add(Arrays.asList(map.get(s2),i));
                    }
                }
            }
        }
        return ans;
    }
    public boolean helper(String s,int left,int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}