
/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/partition-into-subsets-official/ojquestion
*/


import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();

    if (n == 0 || k == 0 || n < k) {
      System.out.println(0);
      return;
    }

    long[][] dp = new long[k + 1][n + 1];

    for (int t = 1; t <= k; t++) {
      for (int p = 1; p <= n; p++) {
        if (p == t)
          dp[t][p] = 1;
        else if (p > t)
          dp[t][p] = t * dp[t][p - 1] + dp[t - 1][p - 1];
      }
    }
    System.out.println(dp[k][n]);
  }
}
