class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        HashMap<Integer,Integer> rank=new HashMap<Integer,Integer>();
        HashMap<Character,Integer> suit=new HashMap<Character,Integer>();
        for(int i=0;i<5;i++){
            rank.put(ranks[i],rank.getOrDefault(ranks[i],0)+1);
            suit.put(suits[i],suit.getOrDefault(suits[i],0)+1);
        }
        int count1=0;
        int count2=0;
        for(int a:rank.values()){
            count1=count1<a?a:count1;
        }
        for(int a:suit.values()){
            count2=count2<a?a:count2;
        }
        if(count2==5){
            return "Flush";
        }
        else if(count1>=3){
            return "Three of a Kind";
        }
        else if(count1==2){
            return "Pair";
        }
        else{
            return "High Card";
        }
    }
}