import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int k = 2;
        int result = 0;
        for(int i=0; i< (int)piles.length/3; i++){
            result += piles[piles.length-k];
            k += 2;
            
        }

        return result;
    }
}
