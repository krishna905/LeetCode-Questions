/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/zero-one-knapsack-official/ojquestion


*/



import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
   Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();

    int[] price = new int[n];
   
    for (int i = 0; i < n; i++) {
      price[i] = sc.nextInt();
    }

    int[] weight = new int[n];
   
    for (int i = 0; i < n; i++) {
      weight[i] = sc.nextInt();
    }
    
    int totalcap = sc.nextInt();
    int[][] dp = new int[n + 1][totalcap + 1];
    
    
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        int val = price[i - 1];
        int wt = weight[i - 1];
        
         //If the current capacity is greater than the weight of the current item
        if (j >= wt) { 
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt] + val); // max cost will be max of cost before putting the item and after putting it
        }
        
        //If current capacity is less than weight do not add item to the bag
        else {
          dp[i][j] = dp[i - 1][j]; 
        }
      }
    }

    System.out.println(dp[n][totalcap]);
  }
}
