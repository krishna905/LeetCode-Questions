/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-fence-official/ojquestion
*/

//we can do without storing in dp array too.

import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();

   long dp[]=new long[n+1];
    long same = k * 1;
    dp[1]=same;
    long diff = k *  (k - 1);
    long total = same + diff;

    for (int i = 2; i <=n; i++) {
      same = diff * 1;
      diff = total * (k - 1);
      total = same + diff;
      dp[i]=total;
    }

    System.out.println(dp[n-1]);
  }
}
