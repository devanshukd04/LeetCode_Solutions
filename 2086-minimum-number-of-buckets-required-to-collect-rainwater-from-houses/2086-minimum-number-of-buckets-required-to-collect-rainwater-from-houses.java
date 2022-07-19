class Solution {
    public int minimumBuckets(String street) {
        List<Integer> list=new ArrayList<Integer>();
        HashSet<Integer> set=new HashSet<Integer>();
        int count=0;
        if(street.length()==1){
            return street.charAt(0)=='H'?-1:0;
        }
        int[] check=new int[street.length()];
        // for(int i=0;i<street.length();i++){
        //     if(street.charAt(i)=='H'){
        //         list.add(i);
        //     }
        // }
        int i=0;
        System.out.println(street);
        while(i<street.length()-1){
            if(street.charAt(i)=='H' && street.charAt(i)==street.charAt(i+1)){
                if(i-1>=0 && street.charAt(i-1)!='H'){
                    if(!set.contains(i-1)){
                        set.add(i-1);
                        System.out.println(i);
                        ++count;
                    }
                }
                else{
                    return -1;
                }
            }
            
            else if(street.charAt(i)=='H' && street.charAt(i)!=street.charAt(i+1)){
                if(!set.contains(i+1)){
                    set.add(i+1);
                    System.out.println(i);
                    ++count;
                }
                i+=2;
            }
            System.out.println(i+" "+count);
            ++i;
        }
        if(street.charAt(street.length()-1)=='H'){
            if(street.charAt(street.length()-2)=='H'){
                return -1;
            }
            else{
                if(!set.contains(street.length()-2)){
                    ++count;
                }
            }
        }
        return count;
    }
}