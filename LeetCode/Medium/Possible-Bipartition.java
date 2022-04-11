class Solution {
    public static boolean possibleBipartition(int N, int[][] dislikes) {

        int[] peopleGroup = new int[N+1];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] dislike : dislikes) {
            if(!graph.containsKey(dislike[0])) graph.put(dislike[0], new ArrayList<>());
            if(!graph.containsKey(dislike[1])) graph.put(dislike[1], new ArrayList<>());

            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);

        }
        for (int[] dislike : dislikes) {
            if(peopleGroup[dislike[0]] ==0 && !dfs(graph,peopleGroup,dislike[0] , 1)){
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(Map<Integer,List<Integer>> graph, int[] peopleGroup, int curPerson, int groupNumber) {


        if(peopleGroup[curPerson] == groupNumber) return false;
        peopleGroup[curPerson] = groupNumber; // 그룹 할당
        List<Integer> haters = graph.get(curPerson);// curPerson을 싫어하는 사람


        for (Integer hater : haters) { // curPerson 싫어하는 사람 순회
            if (peopleGroup[curPerson] == peopleGroup[hater]) return false; // curPerson의 그룹 == hater-1 group
            if (peopleGroup[hater] == 0 && !dfs(graph, peopleGroup, hater, -groupNumber)) return false;

        }
        return true;

    }
}
