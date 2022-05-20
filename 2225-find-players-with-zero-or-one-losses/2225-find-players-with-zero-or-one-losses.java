class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        Boolean[] a=new Boolean[matches.length];
        Set<Integer> b=new HashSet<Integer>();
        Set<Integer> c=new HashSet<Integer>();
        List<Integer> e=new ArrayList<Integer>();
        Set<Integer> f=new HashSet<Integer>();
        int d;
        Arrays.fill(a,Boolean.TRUE);
        for(int i=0;i<matches.length;i++){
            f.add(matches[i][0]);
            f.add(matches[i][1]);
            if(!b.contains(matches[i][1])){
                b.add(matches[i][1]);
            }
            else if(b.contains(matches[i][1])){
                c.add(matches[i][1]);
            }
        }
        e.addAll(f);
        Collections.sort(e);
        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        for(int i=0;i<e.size();i++){
            d=e.get(i);
            if(!b.contains(d) && !c.contains(d)){
                list1.add(d);
            }
            else if(b.contains(d) && !c.contains(d)){
                list2.add(d);
            }
        }
        list.add(list1);
        list.add(list2);
        return list;
    }
}