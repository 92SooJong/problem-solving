class Solution {
    public static void createDigitWithString(String[][] digitWithString){
        digitWithString[2][0] = "a";digitWithString[2][1] = "b";digitWithString[2][2] = "c";
        digitWithString[3][0] = "d";digitWithString[3][1] = "e";digitWithString[3][2] = "f";
        digitWithString[4][0] = "g";digitWithString[4][1] = "h";digitWithString[4][2] = "i";
        digitWithString[5][0] = "j";digitWithString[5][1] = "k";digitWithString[5][2] = "l";
        digitWithString[6][0] = "m";digitWithString[6][1] = "n";digitWithString[6][2] = "o";
        digitWithString[7][0] = "p";digitWithString[7][1] = "q";digitWithString[7][2] = "r";digitWithString[7][3] = "s";
        digitWithString[8][0] = "t";digitWithString[8][1] = "u";digitWithString[8][2] = "v";
        digitWithString[9][0] = "w";digitWithString[9][1] = "x";digitWithString[9][2] = "y";digitWithString[9][3] = "z";

    }

    public static void recursive(String[][] digitWithString, List<String> answer , String madeText, String input, int curIndex){

        if(curIndex >= input.length()){
            answer.add(madeText);
        }else{

            int digit = input.charAt(curIndex)-48;
            String[] alphabets = digitWithString[digit];
            for (String alphabet : alphabets) {
                if(alphabet ==null) continue;
                recursive(digitWithString,answer,madeText+alphabet,input,curIndex+1);
            }

        }
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0) return result;
        String[][] digitWithString = new String[10][4];
        createDigitWithString(digitWithString);
        recursive(digitWithString,result,"",digits,0);

        return result;
    }
}
