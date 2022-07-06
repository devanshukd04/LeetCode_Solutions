class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        boolean flag=true;
        List<Integer> d=new ArrayList<Integer>();
        while(left<=right){
            int a=left;
            flag=true;
            while(a>0){
                int b=a%10;
                a/=10;
                if(b==0 || !(left%b==0)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                d.add(left);
            }
            left++;
        }
        return d;
    }
}