class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double a=(double)income;
        double b;
        double c;
        double d=0;
        if(income==0){
            return a;
        }
        if(income>brackets[0][0]){
            b=brackets[0][0];
            c=b*brackets[0][1]/100;
            d+=c;
        }
        else{
            b=income;
            c=b*brackets[0][1]/100;
            d+=c;
            return d;
        }            
        for(int i=1;i<brackets.length ;i++){
            if(income>brackets[i-1][0]){
                if(income>brackets[i][0]){
                    b=brackets[i][0]-brackets[i-1][0];
                    c=b*brackets[i][1]/100;
                    d+=c;     
                } 
                else{
                    b=income-brackets[i-1][0];
                    c=b*brackets[i][1]/100;
                    d+=c;     
                    return d;
                }
            }
        }
        return d;
    }
}