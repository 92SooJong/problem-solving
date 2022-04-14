class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result= new int[nums.length];
        int[] partSum = new int[nums.length];
        partSum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            partSum[i] = partSum[i-1] + nums[i];
        }
        
        
        for(int i=0; i<nums.length; i++){

            // 좌측 상수합 - 기준합
            int leftSum = partSum[i]; // i까지의 합 ( i포함 )
            int rightSum = partSum[nums.length-1] - partSum[i]; // 끝부터 i+1 까지
            result[i] = Math.abs(leftSum - (nums[i]*(i+1))) + Math.abs(rightSum - (nums[i] * (nums.length-i-1)));

        }
        return result;
    }
}
