// String concat 대신 , StringBuilder의 Append로 속도 개선
class Solution {
    public static String getSmallestString(int n, int k) {
        StringBuilder result = new StringBuilder("");
        
        for(int i=1; i<n; i++){

            int chance = n-i;
            int maxValueWithChance = chance * 26;

            int minimumAlphabet = k - maxValueWithChance;
            if(minimumAlphabet <= 0) minimumAlphabet = 1;
            result.append(Character.toString(96+minimumAlphabet));

            k= k-minimumAlphabet;

        }

        result.append(Character.toString(96+k));

        return result.toString();
    }
}
