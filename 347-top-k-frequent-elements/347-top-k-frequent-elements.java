class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
        PriorityQueue<Integer> d=new PriorityQueue<Integer>();
        List<Integer> b=new ArrayList<Integer>();
        List<Integer> c=new ArrayList<Integer>();
        int g;
        for(int i=0;i<nums.length;i++){
            if(a.containsKey(nums[i])){
                g=a.get(nums[i]);
                a.put(nums[i],g+1);
            }
            else{
                b.add(nums[i]);
                a.put(nums[i],1);
            }
        }
        for(int i=0;i<b.size();i++){
            c.add(a.get(b.get(i)));
            d.add(a.get(b.get(i)));
        }
        int e=a.size()-k;
        while(e>0){
            e--;
            d.poll();
        }
        int[] f=new int[k];
        k--;
        while(k>=0){
            int h=c.indexOf(d.poll());
            f[k]=b.get(h);
            b.remove(h);
            c.remove(h);
            k--;
        }
        return f;
    }
}