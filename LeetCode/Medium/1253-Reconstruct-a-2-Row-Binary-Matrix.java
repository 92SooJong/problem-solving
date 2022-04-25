class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result= new ArrayList<>();

        // if sum(colsum) > upper + lower is true, exit
        int sum = Arrays.stream(colsum).sum();
        if(sum > upper + lower) return result;
        
        int originalUpper = upper;
        int originalLower = lower;
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        // upper와 lower중 큰 숫자를 먼저쓰자
        for (int col : colsum) {
            int upperNumber = 0;
            int lowerNumber = 0;
            if(col == 2){
                upper--;
                lower--;
                upperNumber = 1;
                lowerNumber = 1;
            } else if(col==1){
                if(upper > lower){
                    upper--;
                    upperNumber = 1;
                } else {
                    lower--;
                    lowerNumber = 1;
                }
            }

            result.get(0).add(upperNumber);
            result.get(1).add(lowerNumber);


        }

        if(upper <0 || lower <0) {
            result.clear();
            return result;
        }
        
        int upperSum = result.get(0).stream().mapToInt(s -> s).sum();
        int lowerSum = result.get(1).stream().mapToInt(s -> s).sum();
        if(originalUpper != upperSum || originalLower != lowerSum){
            result.clear();
            return result;
        }


        return result;
    }
}
