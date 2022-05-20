class Solution {
    public int minimumCardPickup(int[] cards) {
        int c=-1;
        int d;
        HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
        for(int i=0;i<cards.length;i++){
            if(a.containsKey(cards[i])){
                d=a.get(cards[i]);
                d=i-d+1;
                if(c==-1){
                    c=d;
                }
                else if(d<c){
                    c=d;
                }
                a.put(cards[i],i);
            }
            else{
                a.put(cards[i],i);
            }
        }
        if(c!=-1){
            return c;
        }
        c=-1;
        return c;
    }
}