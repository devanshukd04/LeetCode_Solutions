class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        int[] parentCount=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] prerequisite:prerequisites){
            map.get(prerequisite[1]).add(prerequisite[0]);
            parentCount[prerequisite[0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        
        for(int i=0;i<parentCount.length;i++){
            if(parentCount[i]==0){
                queue.offer(i);
            }
        }
        
        int i=0;
        int[] result=new int[numCourses];
        while(!queue.isEmpty()){
            int course=queue.poll();
            result[i++]=course;
            for(int nextCourse:map.get(course)){
                parentCount[nextCourse]--;
                if(parentCount[nextCourse]==0){
                    queue.offer(nextCourse);
                }
            }
        }
        
        if(i!=numCourses){
            return new int[0];
        }
        return result;
    }
}