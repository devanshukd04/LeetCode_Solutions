class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        boolean stat=false;
        List<List<String>> a=new ArrayList<List<String>>();
        for(int i=0;i<searchWord.length();i++){
            String c=searchWord.substring(0,i+1);
            stat=false;
            List<String> b=new ArrayList<String>();
            int count=0;
            for(int j=0;j<products.length;j++){
                if(products[j].startsWith(c) && count<3){
                    ++count;
                    stat=true;
                    b.add(products[j]);
                }
                else{
                    if(stat || count==3){
                        break;
                    }
                }
            }
            a.add(b);
        }
        return a;
    }
}