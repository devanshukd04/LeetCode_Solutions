class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans=0;
        //Creating a map to store type of garbage and where it is found
        HashMap<Character,List<Integer>> map=new HashMap<Character,List<Integer>>();
        char[] var=new char[3];
        var[0]='M';
        var[1]='P';
        var[2]='G';
        //Creating an empty arraylist for each type of garbage
        for(int i=0;i<var.length;i++){
            List<Integer> list=new ArrayList<Integer>();
            map.put(var[i],list);
        }
        
        //Itertaing over each position and updating the map
        for(int i=0;i<garbage.length;i++){
            for(int j=0;j<garbage[i].length();j++){
                if(map.containsKey(garbage[i].charAt(j))){
                    List<Integer> a=map.get(garbage[i].charAt(j));
                    a.add(i);
                }
                else{
                    List<Integer> a=new ArrayList<Integer>();
                    a.add(i);
                    map.put(garbage[i].charAt(j),a);
                }
            }
        }
        
        //Iterating over each type of metal
        for(int i=0;i<var.length;i++){
            //Accesing the list of postiions for that garbage
            List<Integer> list=map.get(var[i]);
            int j=0;
            //Total minutes require for a particular type of garbage is tore in ans1
            int ans1=0;
            int pos=0;
            //Iterating over list
            while(j<list.size()){
                //If different postion so adding the travel time to ans1
                if(list.get(j)!=pos){
                    for(int k=pos;k<list.get(j);k++){
                        ans1+=travel[k];
                    }
                    ans1++;
                    pos=list.get(j);
                }
                //Adding the garbage collection time to ans
                else{
                    ans1++;
                }
                ++j;
            }
            //Adding ans to ans1
            ans+=ans1;
        }
        return ans;
    }
}