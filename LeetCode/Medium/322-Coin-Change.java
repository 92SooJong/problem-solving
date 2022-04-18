class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(coins);
        List<Integer> coinList = new ArrayList<>();
        for (int coin : coins) {
            coinList.add(coin);
        }


        for(int money=1; money<=amount; money++){

            if(coinList.contains(money)) {
                dp[money] = 1;
                continue;
            }
            for (int coin : coins) {

                if(money > coin){
                    dp[money] = Math.min(dp[money],dp[money-coin]);
                }
            }

            if(dp[money] !=Integer.MAX_VALUE) dp[money]++;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    
    }
}
