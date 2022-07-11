class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i=0,j=0;
        int a=0,b=0;
        HashSet<Integer> a1=new HashSet<Integer>();
        while(i<buses.length-1 && j<passengers.length){
            for(int k=0;k<capacity && j<passengers.length;k++){
                if(passengers[j]<=buses[i]){
                    a1.add(passengers[j]);
                    j++;
                }
                else{
                    break;
                }
            }
            i++;
        }
        int c1=0;

        for(int k=0;k<capacity && j<passengers.length;k++){
            ++c1;
            if(passengers[j]<=buses[i]){
                a=passengers[j];
                a1.add(passengers[j]);
                j++;
            }
            else{
                --c1;
                break;
            }
        }
        if(c1<capacity){
            b=buses[buses.length-1];
        }
        else{
            b=a-1;
        }
        while(a1.contains(b)){
            b--;
        }
        return b;
    }
}