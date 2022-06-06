class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min=Integer.MAX_VALUE;
        List<String> b=new ArrayList<String>();
        HashMap<String,Integer> a=new HashMap<String,Integer>();
        for(int i=0;i<list1.length;i++){
            a.put(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            if(a.containsKey(list2[i])){
                int c=i+a.get(list2[i]);
                if(min>c){
                    min=c;
                    b.clear();
                    b.add(list2[i]);
                }
                else if(min==c){
                    b.add(list2[i]);
                }
            }
        }
        String[] c=new String[b.size()];
        for(int i=0;i<b.size();i++){
            c[i]=b.get(i);
        }
        return c;
    }
}