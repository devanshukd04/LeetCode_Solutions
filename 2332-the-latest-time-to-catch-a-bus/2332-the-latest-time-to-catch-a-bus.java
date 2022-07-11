class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i=0,j=0;
        int a=0,b=0;
        int b1=0;
        boolean flag=false;
        HashSet<Integer> a1=new HashSet<Integer>();
        while(i<buses.length-1 && j<passengers.length){
            flag =false;
            for(int k=0;k<capacity && j<passengers.length;k++){
                if(passengers[j]<=buses[i]){
                    a1.add(passengers[j]);
                    j++;
                    flag=true;
                }
                else{
                    flag=false;
                    break;
                }
            }
            i++;
        }
        flag=true;
        int c1=0;
        System.out.println(a1);

        for(int k=0;k<capacity && j<passengers.length;k++){
            ++c1;
            b=a;
            if(passengers[j]<=buses[i]){
                a=passengers[j];
                a1.add(passengers[j]);
                System.out.print(a+" ");
                j++;
            }
            else{
                System.out.print(j+" "+a);
                --c1;
                flag=false;
                break;
            }
        }
        System.out.println(" c1 "+c1+" "+capacity+" "+buses[buses.length-1]+" "+a+" "+b);
        if(c1<capacity){
            b1=buses[buses.length-1];
        }
        else{
            b1=a-1;
        }
        System.out.println(b1);
        
        // if(flag==false || c1<capacity){
        //     b1=a+1<=buses[buses.length-1]?a+1:passengers[j-1];
        // }
        // else{
        //     b1=passengers[j-1];   
        // }
        // b1=buses[buses.length-1];
        // System.out.println()
        System.out.println(Arrays.toString(buses));
        System.out.println(Arrays.toString(passengers));
        System.out.println(a1);

        while(a1.contains(b1)){
            b1--;
        }
        return b1;
    }
}