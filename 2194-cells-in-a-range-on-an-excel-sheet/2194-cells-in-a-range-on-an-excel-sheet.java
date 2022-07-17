class Solution {
    public List<String> cellsInRange(String s) {
        List<String> list=new ArrayList<String>();
        int g=Integer.valueOf('A');
        int a=s.charAt(0)-'A';
        int b=s.charAt(3)-'A';
        int c=Integer.valueOf(s.substring(1,2));
        int d=Integer.valueOf(s.substring(4,5));
        char f;
        String e;
        for(int i=a;i<=b;i++){
            f=(char)(i+g);
            for(int j=c;j<=d;j++){
                e=f+Integer.toString(j);
                list.add(e);
            }
        }
        return list;
        
    }
}