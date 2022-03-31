class Solution {
    public int romanToInt(String s) {
        int answer= 0;
        int substringStartIndex= 0;
        while(true){
            if( s.startsWith("IV")){
                answer += 4;
                substringStartIndex = 2;
            } else if(s.startsWith("IX")){
                answer += 9;
                substringStartIndex = 2;
            } else if(s.startsWith("XL")){
                answer += 40;
                substringStartIndex = 2;
            } else if(s.startsWith("XC")){
                answer += 90;
                substringStartIndex = 2;
            } else if(s.startsWith("CD")){
                answer += 400;
                substringStartIndex = 2;
            } else if(s.startsWith("CM")){
                answer += 900;
                substringStartIndex = 2;
            } else if(s.startsWith("I")){
                answer += 1;
                substringStartIndex = 1;
            } else if(s.startsWith("V")){
                answer += 5;
                substringStartIndex = 1;
            } else if(s.startsWith("X")){
                answer += 10;
                substringStartIndex = 1;
            } else if(s.startsWith("L")){
                answer += 50;
                substringStartIndex = 1;
            } else if(s.startsWith("C")){
                answer += 100;
                substringStartIndex = 1;
            } else if(s.startsWith("D")){
                answer += 500;
                substringStartIndex = 1;
            } else if(s.startsWith("M")){
                answer += 1000;
                substringStartIndex = 1;
            }

            if(substringStartIndex > s.length()) break;
            s = s.substring(substringStartIndex);

        }

        return answer;
    }
}
