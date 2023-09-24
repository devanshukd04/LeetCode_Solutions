class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int i,a,sum,b;
        double n;
        boolean stat;
        if(query_row==0 && query_glass==0){
            if(poured>=1){
                return 1;
            }
            return poured;
        }
        List<List<Double>> list =new ArrayList<>();
        List<Double> list2 =new ArrayList<Double>();
        list2.add((double)(poured-1)/2);
        list.add(list2);
        i=1;
        while(i<query_row){
            List<Double> list1 =new ArrayList<Double>();
            List<Double> a1=list.get(list.size()-1);
            stat=true;
            for(int j=0;j<=a1.size();j++){
                if(j==0){
                    n=a1.get(0)-1;
                    if(n<=0){
                        n=0;
                    }
                    else{
                        stat=false;
                    }
                    list1.add((double)n/2);
                }
                else if(j==a1.size()){
                    n=a1.get(j-1)-1;
                    if(n<=0){
                        n=0;
                    }
                    else{
                        stat=false;
                    }
                    list1.add((double)n/2);
                }
                else{
                    n=a1.get(j)+a1.get(j-1)-1;
                    if(n<=0){
                        n=0;
                    }
                    else{
                        stat=false;
                    }
                    list1.add((double)n/2);
                }
            }
            if(stat){
                return 0;
            }
            list.add(list1);
            ++i;
        }
        List<Double> a1=list.get(list.size()-1);
        if(query_glass==0){
            if(a1.get(0)<=0){
                return 0;
            }
            else if(a1.get(0)>=1){
                return 1;
            }
            return a1.get(0);
        }
        else if(query_glass==query_row){
            if(a1.get(a1.size()-1)<=0){
                return 0;
            }
            else if(a1.get(a1.size()-1)>=1){
                return 1;
            }
            return a1.get(a1.size()-1);
        }
        else{
            if((a1.get(query_glass)+a1.get(query_glass-1))<=0){
                return 0;
            }
            else if((a1.get(query_glass)+a1.get(query_glass-1))>=1){
                return 1;
            }
            return a1.get(query_glass)+a1.get(query_glass-1);
        }
    }
}