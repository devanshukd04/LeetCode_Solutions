class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        List<Integer> a=new ArrayList<Integer>();
        int count,j=0;
        Arrays.sort(special);
        a.add(special[0]-bottom);
        for(int i=1;i<special.length;i++){
            j=special[i]-special[i-1]-1;
            a.add(j);
        }
        a.add(top-special[special.length-1]);
        count=Collections.max(a);
        return count;
    }
}