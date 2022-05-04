class Solution {
    
    public static int recursive(Map<Integer,List<Integer>> employeeMap,int[] informTime,int startId,int time){

        if(employeeMap.get(startId).size() == 0){
            return time;
        }else{

            List<Integer> employees = employeeMap.get(startId);
            int maxTime = time;
            for (Integer employee : employees) {
                maxTime = Math.max(maxTime, recursive(employeeMap,informTime,employee,time+informTime[startId]));
            }
            return maxTime;
        }

    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,List<Integer>> employeeMap = new HashMap<>();
        // initialize Map
        for(int i=0; i<n; i++){
            employeeMap.put(i,new ArrayList<>());
        }

        // key : employee // value : subordinates
        for(int i=0; i< manager.length; i++){
            
            if(manager[i] == -1) continue;
            employeeMap.get(manager[i]).add(i);
        }


        return recursive(employeeMap,informTime,headID,0);
    }
}
