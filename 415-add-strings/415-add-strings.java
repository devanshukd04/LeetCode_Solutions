class Solution {
    public String addStrings(String num1, String num2) {
        int i=0;
        StringBuilder nums1=new StringBuilder(num1);
        nums1=nums1.reverse();
        StringBuilder nums2=new StringBuilder(num2);
        nums2=nums2.reverse();
        int a;
        int b;
        int c=0;
        String result="";
        while(i<nums1.length() || i<num2.length()){
            if(i<nums1.length()){
                a=nums1.charAt(i)-'0';
            }
            else{
                a=0;
            }
            if(i<nums2.length()){
                b=nums2.charAt(i)-'0';
            }
            else{
                b=0;
            }
            result=(a+b+c)%10+result;
            c=(a+b+c)/10;
            i++;
        }
        if(c!=0){
            result=c+result;
        }
        return result;
    }
}