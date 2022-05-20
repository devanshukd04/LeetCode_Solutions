class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> list1=new ArrayList<List<String>>();
        int j=0;
        String k;
        String[] str=new String[strs.length]; 
        char[] carray;
        boolean[] stat=new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            str[i]=strs[i];
            stat[i]=true;
        }
        for(int i=0;i<str.length;i++){
            carray=str[i].toCharArray();
            Arrays.sort(carray);
            str[i]=String.valueOf(carray);
        }
        while(j<str.length){
            if(stat[j]){
                k=str[j];
                stat[j]=false;
                ArrayList<String> list=new ArrayList<String>();
                list.add(strs[j]);
                for(int i=j+1;i<str.length;i++){
                    if(str[i].equals(k) && stat[i]==true){
                        stat[i]=false;
                        list.add(strs[i]);
                    }
                }
                list1.add(list);
            }
            j+=1;
        }
        return list1;
    }
}