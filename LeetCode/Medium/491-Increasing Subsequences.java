/**
 정답의 중복을 제거하기 위해 ArrayList의 contains를 사용했으나 시간초과 발생
 Set을 사용해서 중복된 데이터가 보관되지 않도록 함.
 해결을 위해 HashSet을 사용했는데 submit을 할때마다 시간이 일정하지 않음.
 
 깊은 복사,얕은 복사에 대한 개념정리 할 수 있는 문제였음.
 정답에서 중복 배제를 원할땐 Set을 적극 활용.
*/

class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        HashSet<ArrayList<Integer>> tempResult= new HashSet<>();
        
        for(int i=0; i<nums.length; i++){


            HashSet<ArrayList<Integer>> clone = new HashSet<>(tempResult);
            // 선택한다
            for (ArrayList<Integer> integers : clone) {
                if(integers.get(integers.size()-1) <= nums[i]){
                    ArrayList<Integer> clone1 = new ArrayList<>(integers);
                    clone1.add(nums[i]);
                    tempResult.add(clone1);

                }
            }

            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(nums[i]);
            tempResult.add(objects);


        }


        for (List<Integer> integers : tempResult) {
            if(integers.size()>1){
                result.add(integers);
            }
        }

        return result;
    }
}
