import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public static int getRank(int count){

        if(count>=6) return 1;
        else if(count==5) return 2;
        else if(count==4) return 3;
        else if(count==3) return 4;
        else if(count==2) return 5;
        else return 6;

    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};

        List<Integer> lottoList = new ArrayList<>();
        for (int lotto : lottos) lottoList.add(lotto);
        List<Integer> winList = new ArrayList<>();
        for (int win : win_nums) winList.add(win);

        // 최저순위
        int count =0;
        for (Integer win : winList) {
            if(lottoList.contains(win)) count++;
        }
        int zeroCount = (int)lottoList.stream().filter( a -> a == 0).count();
        answer[1] = getRank(count);
        answer[0] = getRank(count+zeroCount);


        return answer;
    }
}
