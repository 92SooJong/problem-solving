/**
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. 
You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

*/

/**
  
  answer를 전역변수로 만들지 않고 dot 메소드의 인자로 넘기는 방식으로 처리하는게 더 깔끔함.
  시작 위치조정을 startIndex를 +1 하는 방식을 사용했는데, index는 0에서 시작하도록 하고 s의 가장 앞을 잘라서 넘기는 방식으로 시작위치 조정이 가능함.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    static List<String> answer = new ArrayList<>();

    public static boolean isValid(String ip){

        if(ip.endsWith(".")) return false;
        if(ip.length() - ip.replace(".", "").length() != 3) return false;

        String[] split = ip.split("\\.");
        for (String s : split) {
            if(s.length() > 3) return false; // prevent over Intger size
            if(s.equals("")) return false;
            if(s.length() > 1 && s.startsWith("0")) return false;
            if( Integer.parseInt(s) > 255) return false;
        }

        return true;

    }
    
    
    public static void dot(String[] stringList , int startIndex ,String madeIp ){

        int dotCount = madeIp.length() - madeIp.replace(".", "").length();
        // complete
        if(dotCount == 4 || startIndex > stringList.length-1) {

            if(isValid(String.join("", madeIp))){
                answer.add(madeIp);
            }
            return;
        }

        // Choose Dot
        dot(stringList,startIndex,madeIp.concat(".") );
        // Choose Number
        dot(stringList,startIndex +1,madeIp.concat(stringList[startIndex]) );


    }
    
    public List<String> restoreIpAddresses(String s) {
        answer.clear();
        String[] split = s.split("");
        dot(split , 0, "");
        return answer;
    }
}


/** https://leetcode.com/problems/restore-ip-addresses/discuss/30949/My-code-in-Java
# DFS는 불필요한 경우의 수를 제거하진 않음
# 백트래킹은 불필요한 경우의수를 만나면 더이상 탐색하지 않음
# 아래 코드는 백트래킹으로 구현된 예시

1. s를 앞쪽부터 substring(0, i) 쪼갠다. i는 3을 넘지 않는다.
2. 쪼갠 숫자가 255가 넘지 않는지 검사한다.
3. 재귀호출 한다. 이때, s에서 substring(0,i)만큼은 제거하고 넘긴다. 

*/
/**
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        doRestore(result, "", s, 0);
        return result;
    }
    
    private void doRestore(List<String> result, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4)
                result.add(path.substring(1));
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) { // Avoid leading 0
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255)
                doRestore(result, path + "." + part, s.substring(i), k + 1);
        }
    }
*/
