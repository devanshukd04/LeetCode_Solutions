class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int ans=0;
        int[] cal=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int start=0;
        int startMonth,startDate=0;
        startMonth=Math.max(Integer.valueOf(arriveAlice.substring(0,2)),Integer.valueOf(arriveBob.substring(0,2)));
        if(Integer.valueOf(arriveAlice.substring(0,2))==Integer.valueOf(arriveBob.substring(0,2))){
            startDate=Math.max(Integer.valueOf(arriveAlice.substring(3,5)),Integer.valueOf(arriveBob.substring(3,5)));
        }
        else{
            if(startMonth==Integer.valueOf(arriveAlice.substring(0,2))){
                startDate=Integer.valueOf(arriveAlice.substring(3,5));
            }
            else{
                startDate=Integer.valueOf(arriveBob.substring(3,5));
            }
        }
        
        int endMonth,endDate=0;
        endMonth=Math.min(Integer.valueOf(leaveAlice.substring(0,2)),Integer.valueOf(leaveBob.substring(0,2)));
        if(Integer.valueOf(leaveAlice.substring(0,2))==Integer.valueOf(leaveBob.substring(0,2))){
            endDate=Math.min(Integer.valueOf(leaveAlice.substring(3,5)),Integer.valueOf(leaveBob.substring(3,5)));
        }
        else{
            if(endMonth==Integer.valueOf(leaveAlice.substring(0,2))){
                endDate=Integer.valueOf(leaveAlice.substring(3,5));
            }
            else{
                endDate=Integer.valueOf(leaveBob.substring(3,5));
            }
        }
        System.out.println(startDate+" "+startMonth+" "+endDate+" "+endMonth);
        if(startMonth==endMonth){
            return endDate-startDate+1>0?endDate-startDate+1:0;
        }
        if(startMonth>endMonth){
            return 0;
        }
        ans+=cal[startMonth-1]-startDate+1;
        startMonth++;
        while(startMonth<endMonth){
            ans+=cal[startMonth-1];
            startMonth++;
        }
        ans+=endDate;
        return ans;
    }
}