import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = nums.clone();
        
        k = k > nums.length ? (int)k%nums.length : k;
        for(int i=0; i<k; i++){
            nums[i] = temp[nums.length - k + i];
        }

        for(int i=k; i<nums.length; i++){
            nums[i] = temp[i-k];
        }
    }
}
