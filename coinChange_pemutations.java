/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-permutations-official/ojquestion


*/





import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
         Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int coins[]=new int[n];
        
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        int amt=sc.nextInt();
        
        int dp[]=new int[amt+1];
         dp[0]=1;
        
        for(int i=1;i<dp.length;i++){
            
            for(int j=0; j<coins.length;j++){
                
                if(coins[j]<=i)
                dp[i] += dp[i-coins[j]];
            }
        }
        System.out.println(dp[amt]);

    }
}
