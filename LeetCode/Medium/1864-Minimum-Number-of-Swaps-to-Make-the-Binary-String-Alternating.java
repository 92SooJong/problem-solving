class Solution {
    
    public static int getAnswer(String s, char startNumber){
        
        
        int answer = 0;
        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) != startNumber) answer++;
            startNumber = startNumber == '1' ? '0' : '1';

        }
        
        return answer/2;
    }

    public int minSwaps(String s) {
        if(s.length() == 1) return 0;

        // 개수가 1개 이상 차이나면 답을 구할 수 없다.
        int countZero=0;
        int countOne =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0') countZero++;
            else countOne++;
        }
        if(countOne> countZero+1 || countZero> countOne+1) return -1;
        
        if(countOne > countZero) return getAnswer(s,'1'); 
        else if(countZero > countOne)return getAnswer(s,'0');
        
        return Math.min(getAnswer(s,'0'), getAnswer(s,'1'));
        

    }
}
