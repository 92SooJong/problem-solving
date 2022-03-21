import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maxSubArray(int[] nums) {
        
        List<Integer> result= new ArrayList<>();
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        result.add(dp[0]);
        for(int i=1; i<nums.length; i++){

            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            result.add(dp[i]);
        }

        return Collections.max(result);
        
    }
}
