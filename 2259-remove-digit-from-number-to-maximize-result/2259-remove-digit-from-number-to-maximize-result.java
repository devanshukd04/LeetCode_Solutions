class Solution {
    public String removeDigit(String number, char digit) {
        int a,e;
        String b;
        int c=0;
        List<String> array=new ArrayList<String>();
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)==digit){
                ++c;
            }
        }
        a=number.indexOf(digit);
        b=number.substring(0,a)+number.substring(a+1);
        array.add(b);
        --c;
        e=a+1;
        for(int i=c;i>0;i--){
            a=number.indexOf(digit,e);
            b=number.substring(0,a)+number.substring(a+1);
            array.add(b);
            e=a+1;
        }
        b=Collections.max(array);
        return b;
        
    }
}