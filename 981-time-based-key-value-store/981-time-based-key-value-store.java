class TimeMap {
    HashMap<String,HashMap<Integer,String>> map;
    public TimeMap() {
        this.map=new HashMap<String,HashMap<Integer,String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<Integer,String> tempMap=this.map.getOrDefault(key,new HashMap<Integer,String>());
        tempMap.put(timestamp,value);
        map.put(key,tempMap);
    }
    
    public String get(String key, int timestamp) {
        if(!this.map.containsKey(key)){
            return "";
        }
        String ans="";
        for(int i=timestamp;i>=1;i--){
            if(this.map.get(key).containsKey(i)){
                return map.get(key).get(i);
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */