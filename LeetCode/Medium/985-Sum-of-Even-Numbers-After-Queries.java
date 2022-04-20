class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] %2 == 0) sum += nums[i];
        }

        int[] result = new int[nums.length];
        for(int i=0; i<queries.length; i++){

            int origin = nums[queries[i][1]];
            boolean isOriginOdd = origin % 2 != 0;
            nums[queries[i][1]] += queries[i][0];
            boolean isOdd = nums[queries[i][1]] %2 != 0;

            if(!isOriginOdd && isOdd) sum -= origin;
            else if(isOriginOdd && !isOdd) sum += nums[queries[i][1]];
            else if(!isOriginOdd && !isOdd) sum += queries[i][0];

            result[i] = sum;
        }
        
        return result;
    }
}
