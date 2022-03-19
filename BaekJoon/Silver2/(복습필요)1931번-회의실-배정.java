
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static int maxEndTime = 0; // 종료시간 중 가장 큰수 기록
    public static int minStartTime = (int) Math.pow(2L,31L)-1; // 시작시간 중 가장 작은 수 기록


    public static int findProperEndTime(SortedMap<Integer,List<Integer>> endStartTime , int endTime ){

        // 종료시간을 1씩 늘려본다.
        for(int i=endTime; i<=maxEndTime; i++){

            // 종료시간을 Key로 가지는 시작시간 List가 있다.
            if(endStartTime.containsKey(i)){
                if(endStartTime.get(i).size() == 0) continue; // List에 시작시간 정보가 0건

                // 시작시간 List를 순회한다(오름차순으로)
                for(int j=0; j < endStartTime.get(i).size(); j++){
                    Integer nextStartTime = endStartTime.get(i).get(j); // 시작시간

                    if(endTime <= nextStartTime) { // endTime보다 큰 시작시간이면 사용가능하다
                        endStartTime.get(i).remove(j); // 사용한 시작시간은 list에서 제거한다

                        return i;
                    }
                }
            }
        }
        return -1;


    }

    public static int solve(SortedMap<Integer,List<Integer>> endStartTime){
        int answer = 0;

        int endTime = 0; // 종료시간 0
        while(true){

            // endTime 이후 올 수 있는 가장 효율적인 종료시간을 고른다
            endTime = findProperEndTime(endStartTime,endTime);
            if(endTime == -1) break;
            answer +=1;

        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        // 입
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        int input = Integer.parseInt(bf.readLine());
        SortedMap<Integer,List<Integer>> endStartTime = new TreeMap<>(); // Map<종료시간,List<시작시간>>

        int answer =0;
        int[] fromTo;
        for(int i=0; i<input; i++){

            fromTo = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 종료시간을 Key로 하는 Map만들기, value로는 시작시간에 대한 List 저장
            if(!endStartTime.containsKey(fromTo[1])) endStartTime.put(fromTo[1],new ArrayList<>());
            endStartTime.get(fromTo[1]).add(fromTo[0]);

            // 시작 시간을 정렬한다. HashMap사용시 key는 자동 정렬됨
            List<Integer> sorted = endStartTime.get(fromTo[1]).stream().sorted().collect(Collectors.toList()); // 정렬
            endStartTime.replace(fromTo[1] ,sorted);

            maxEndTime = Math.max(maxEndTime,fromTo[1]); // 종료시간중 가장 큰수
            minStartTime = Math.min(minStartTime,fromTo[0]); // 시작시간중 가장 작은수

        }
        // 문제해결
        answer += solve(endStartTime);
        bw.write(answer +"\n");

        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음


    }

}

