/*
https://leetcode.com/problems/coin-change-2/


*/










class Solution {
    public int change(int amount, int[] coins) {
        
        int dp[]=new int[amount+1];
        dp[0]=1;
        
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<dp.length;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}


/*

----correct code -------
int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
         dp[0]=0;
        
        for(int i=1;i<dp.length;i++){
            
            for(int j=0; j<coins.length;j++){
                
                if(coins[j]<=i)
                dp[i] =Math.min(dp[i], 1+dp[i-coins[j]]) ;
            }
        }
        int res= dp[amount]!=amount+1? dp[amount] : -1;
       System.out.println(res);



*/
