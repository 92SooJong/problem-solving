class Solution {
    public static int getSum(String num , boolean isLeft){
        int sum =0;
        if(isLeft) for(int i=0; i<num.length()/2; i++) if(num.charAt(i) != '?') sum += num.charAt(i) - '0';
        if(!isLeft) for(int i=num.length()/2; i<num.length(); i++) if(num.charAt(i) != '?') sum += num.charAt(i) - '0';
        return sum;
    }

    public static int getQuestionCount(String num , boolean isLeft){
        int count = 0;
        if(isLeft) for(int i=0; i<num.length()/2; i++) if(num.charAt(i) == '?') count++;
        if(!isLeft) for(int i=num.length()/2; i<num.length(); i++) if(num.charAt(i) == '?') count++;
        return count;

    }


    public boolean sumGame(String num) {

        // no question mark
        if(getQuestionCount(num,true) == 0 && getQuestionCount(num,false) == 0){
            return getSum(num,true) != getSum(num,false);
        }
        
        
        // if question mark number is odd, alice always wins.
        if((getQuestionCount(num,true) + getQuestionCount(num,false )) % 2 == 1) return true;
        else{ // question mark number is even
            
            // left & right question mark number is same. assuming no question mark.
            if(getQuestionCount(num,true) == getQuestionCount(num,false)){
                return getSum(num,true) != getSum(num,false);
            }

            int sumDiff = getSum(num,true) - getSum(num,false);
            int queDiff = getQuestionCount(num,true) - getQuestionCount(num,false);
            if((sumDiff >0 && queDiff <0) || (sumDiff <0 && queDiff >0)){
                if(Math.abs(queDiff)/2*9 == Math.abs(sumDiff)) return false;
            } 
            

            return true;
        }
        
    }
}
