class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res=new ArrayList<List<String>>();
        HashMap<String,HashSet<String>> reverse=new HashMap<String,HashSet<String>>();
        HashSet<String> wordSet=new HashSet<String>(wordList);
        wordSet.remove(beginWord);
        Queue<String> queue=new LinkedList<String>();
        queue.add(beginWord);
        HashSet<String> nextLevel=new HashSet<String>();
        boolean findEnd=false;
        while(!queue.isEmpty()){
            String word=queue.remove();
            for(String next:wordSet){
                if(isLadder(word,next)){
                    HashSet<String> reverseLadder=reverse.computeIfAbsent(next,l->new HashSet<String>());
                    reverseLadder.add(word);
                    if(endWord.equals(next)){
                        findEnd=true;
                    }
                    nextLevel.add(next);
                }
            }
            if(queue.isEmpty()){
                if(findEnd){
                    break;
                }
                queue.addAll(nextLevel);
                wordSet.removeAll(nextLevel);
                nextLevel.clear();
            }
        }
        if(!findEnd){
            return res;
        }
        HashSet<String> path=new LinkedHashSet<String>();
        path.add(endWord);
        findPath(endWord,beginWord,reverse,res,path);
        return res;
    }
    public void findPath(String endWord,String beginWord,HashMap<String,HashSet<String>> graph,List<List<String>> res,HashSet<String> path){
        HashSet<String> next=graph.get(endWord);
        if(next==null){
            return;
        }
        for(String word:next){
            path.add(word);
            if(beginWord.equals(word)){
                List<String> shortestPath=new ArrayList<String>(path);
                Collections.reverse(shortestPath);
                res.add(shortestPath);
            }
            else{
                findPath(word,beginWord,graph,res,path);
            }
            path.remove(word);
        }
    }
    public boolean isLadder(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int diffCount=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=t.charAt(i)){
                diffCount++;
            }
            if(diffCount>1){
                return false;
            }
        }
        return true;
    }
}