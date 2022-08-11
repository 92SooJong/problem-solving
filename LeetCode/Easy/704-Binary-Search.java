class Solution {
    public int search(int[] nums, int target) {
        int index = -1;

        int startIndex= 0;
        int endIndex = nums.length-1;

        while(true){
            int middleIndex = (endIndex + startIndex + 1) / 2;

            if (nums[middleIndex] > target) endIndex = middleIndex;
            else if (nums[middleIndex] < target) startIndex = middleIndex;
            else {
                index = middleIndex;
                break;
            }
            
            if(endIndex - startIndex < 2){
                if(nums[startIndex] == target) index = startIndex;
                else if(nums[endIndex] == target) index = endIndex;
                break;
            }
            
        }

        return index;
    }
}


// 아래코드는 모범 답안.
/**
  while문 조건을 아래와 같이 작성함으로써 별도의 종료 조건을 while문 내부에 작성하지 않아도된다.
  startIndex와 endIndex를 if문 수행시마다 Update 하면서 while문이 종료될 수 있도록한다.
*/


class Solution {
    public int search(int[] nums, int target) {
        int startIndex= 0;
        int endIndex = nums.length-1;

        while(startIndex <= endIndex){
             int middleIndex = (endIndex + startIndex + 1) / 2;
             if(nums[middleIndex] > target) endIndex = middleIndex-1;
             else if(nums[middleIndex] < target) startIndex = middleIndex+1;
             else return middleIndex;
        }

        return  -1;
    }
}
