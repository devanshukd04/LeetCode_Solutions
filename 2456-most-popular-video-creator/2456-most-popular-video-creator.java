class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        HashMap<String,Integer> maxID=new HashMap<String,Integer>();
        for(int i=0;i<creators.length;i++){
            map.put(creators[i],map.getOrDefault(creators[i],0)+views[i]);
            int index=maxID.getOrDefault(creators[i],-1);
            if(index==-1){
                maxID.put(creators[i],i);
            }
            else{
                if(views[index]<views[i]){
                    maxID.put(creators[i],i);
                }
                else if(views[index]==views[i]){
                    if(ids[index].compareTo(ids[i])>0){
                        maxID.put(creators[i],i);
                    }
                    else{
                        maxID.put(creators[i],index);
                    }
                }
            }
        }
        List<List<String>> ans=new ArrayList<List<String>>();
        int max=0;
        for(String key:map.keySet()){
            max=max<map.get(key)?map.get(key):max;
        }
        for(String key:map.keySet()){
            if(map.get(key)==max){
                List<String> res=new ArrayList<String>();
                res.add(key);
                res.add(ids[maxID.get(key)]);
                ans.add(res);
            }
        }
        return ans;
    }
}