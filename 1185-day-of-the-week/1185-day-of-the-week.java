class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int sum=4;
        String[] dow={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for(int i=1971;i<year;i++){
            if(i%4==0 && ((i%100!=0) || (i%100==0 && i%400==0))){
                sum+=366;
            }
            else{
                sum+=365;
            }
        }
        for(int i=1;i<month;i++){
            if(i==2){
                if(year%4==0 && ((year%100!=0) || (year%100==0 && year%400==0))){
                    sum+=29;
                }
                else{
                    sum+=28;
                }
            }
            else if(i<8){
                if(i%2==1){
                    sum+=31;
                }
                else{
                    sum+=30;
                }
            }
            else{
                if(!(i%2==1)){
                    sum+=31;
                }
                else{
                    sum+=30;
                }
            }
        }
        sum+=day;
        return dow[sum%7];
    }
}