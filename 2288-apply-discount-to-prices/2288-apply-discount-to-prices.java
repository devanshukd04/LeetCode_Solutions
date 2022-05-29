class Solution {
    public String discountPrices(String sentence, int discount) {
        StringBuffer a=new StringBuffer();
        String[] b=sentence.split(" ");
        String d;
        long d1;
        double e;
        double d2;
        char a1;
        DecimalFormat df = new DecimalFormat("#.00");
        for(int i=0;i<b.length;i++){
            d=b[i];
            if(d.substring(0,1).equals("$")){
                try{
                    d1=Long.parseLong(d.substring(1));
                    e=(((double)d1*(100-discount))/100);
                    d2=(double)e;
                    d=df.format(d2);
                    d1=(int)d2;
                    if(d1<1){
                        a.append("$"+d1+d+" ");
                    }
                    else{
                        a.append("$"+d+" ");   
                    }
                }
                catch(Exception e1){
                    a.append(d+" ");
                }
            }
            else{
                a.append(d+" ");
            }
        }
        
        if(a.charAt(a.length()-1)==' '){
            a.deleteCharAt(a.length()-1);
        }
        return a.toString();
    }
}