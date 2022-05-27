class Solution {
    public int convertTime(String current, String correct) {
        int a=0;
        int b;
        b=Integer.valueOf(correct.substring(3))-Integer.valueOf(current.substring(3));
        b+=(Integer.valueOf(correct.substring(0,2))-Integer.valueOf(current.substring(0,2)))*60;
        while(b!=0){
            if(b>=60){
                b-=60;
            }
            else if(b>=15){
                b-=15;
            }
            else if(b>=5){
                b-=5;
            }
            else{
                b-=1;
            }
            a++;
        }
        return a;
    }
}