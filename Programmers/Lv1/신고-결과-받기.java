import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static List<String> findReportUser( Map<String,ArrayList<String>> reportedUserById ,String id){

        List<String> result = new ArrayList<>();
        for (String reportId : reportedUserById.keySet()) {
            if(reportedUserById.get(reportId).contains(id)){
                result.add(reportId);
            }
        }

        return result;


    }


    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 순서가 보장되는 Map
        Map<String,ArrayList<String>> reportedUserById= new HashMap<>();
        Map<String,Integer> reportedCount = new HashMap<>();
        Map<String,Integer> mailed = new HashMap<>();
        // 초기화
        for(int i=0; i<id_list.length; i++){
            reportedUserById.put(id_list[i], new ArrayList<>());
            reportedCount.put(id_list[i],0);
            mailed.put(id_list[i],0);
        }

        for (String r : report) {
            String reportUser = r.split(" ")[0];
            String reportedUser = r.split(" ")[1];

            // 같은 reportUser에게 신고를 중복해서 당한 경우는 한번만 카운팅 하기 위함
            if(!reportedUserById.get(reportUser).contains(reportedUser)){
                reportedUserById.get(reportUser).add(reportedUser); // reportUser 가 신고한 유저를 list에 넣는다.
                reportedCount.replace(reportedUser , reportedCount.get(reportedUser) + 1); // 신고당한 횟수 1증가
            }


        }

        // 신고를 k번 이상 당한 유저
        for (String reportedUser : reportedCount.keySet()) {
            if(reportedCount.get(reportedUser) >= k ){
                // reportedUser를 신고한 유저들을 찾는다.
                List<String> reportUser = findReportUser(reportedUserById, reportedUser);
                for (String s : reportUser) {
                    mailed.replace(s, mailed.get(s)+1 );
                }
            }
        }

        // 정답출력
        for(int i=0; i<id_list.length; i++){
            answer[i] = mailed.get(id_list[i]);
        }

        return answer;
    }
}
