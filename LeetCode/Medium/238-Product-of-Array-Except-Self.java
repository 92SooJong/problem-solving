class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int productWithoutZero = 1;
        for (int num : nums) {
            if(num == 0) zeroCount++;
            else{
                productWithoutZero *= num;
            }
        }

        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            if(nums[i] == 0 && zeroCount == 1){ // 0이 1개이면서 그 0이 현재의 값인경우
                answer[i] = productWithoutZero;
            } else if(zeroCount >= 1){ // 0이 한개이상 존재하면 무조건 0
                answer[i] =0;
            } else{ // 0이 없는 경우
                answer[i] = productWithoutZero/nums[i];
            }
        }

        return answer;
    }
}
