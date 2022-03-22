/**
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Input: jewels = "z", stones = "ZZ"
Output: 0

*/
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        List<String> stoneList = Arrays.asList(stones.split(""));
        int result = 0;
        for(int i=0; i<jewels.length(); i++){
            char jewel = jewels.charAt(i);
            result += (int)stoneList.stream().filter(s -> s.charAt(0) == jewel).count();
        }
        return result;
    }
}
