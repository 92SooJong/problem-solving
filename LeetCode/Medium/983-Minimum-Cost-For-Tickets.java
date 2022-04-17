// 내가푼 방식(시간초과 발생함)
class Solution {

    public static int recursive(int[] days, int[] costs , int startIndex,int sumCost ){

        if(startIndex >= days.length){
            return sumCost;
        }else{

            // 1-day Ticket
            int a = recursive(days,costs,startIndex+1,sumCost+costs[0]);

            // 7-days Ticket
            int nextIndex = -1;
            for(int i=startIndex; i<days.length; i++){
                if( days[i] >= days[startIndex] + 7){
                    nextIndex = i;
                    break;
                }
            }
            int b = recursive(days,costs,nextIndex == -1 ? days.length : nextIndex ,sumCost+costs[1]);
            

            // 30-days Ticket
            int nextIndex2 = -1;
            for(int i=startIndex; i<days.length; i++){
                if( days[i] >= days[startIndex] + 30){
                    nextIndex2 = i;
                    break;
                }
            }
            int c = recursive(days,costs,nextIndex2 == -1 ? days.length : nextIndex2 ,sumCost+costs[2]);

            return Math.min(a,Math.min(b,c));

        }


    }


    public int mincostTickets(int[] days, int[] costs) {

        return recursive(days, costs , 0,0 );

    }
}










// 아래는 모법답안
class Solution {

    public int mincostTickets(int[] days, int[] costs) {

        // i 날짜까지 커버하는데 사용된 최소비용
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        boolean[] isTravelDay = new boolean[lastDay+1];
        for (int day : days) isTravelDay[day] = true;


        for(int i=1; i<=lastDay; i++){
            if(!isTravelDay[i]) dp[i] = dp[i-1];
            else{
                dp[i] = dp[i-1] + costs[0]; // 1-day 티켓을 이용해 i날짜까지 도착
                dp[i] = Math.min(dp[Math.max(i-7,0)] + costs[1] , dp[i]); // 7-day 티켓을 이용해 i날짜까지 도착
                dp[i] = Math.min(dp[Math.max(i-30,0)] + costs[2] , dp[i]); // 30-day 티켓을 이용해 i날짜까지 도착
            }
        }
        return dp[lastDay];

    }
}
