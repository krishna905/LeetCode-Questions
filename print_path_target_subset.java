/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/print-all-paths-with-target-sum-subset-official/ojquestion
*/




import java.io.*;

import java.util.*;

public class Main {

  public static class Pair {
    int i;
    int j;
    String psf;

    public Pair(int i, int j, String psf) {
      this.i = i;
      this.j = j;
      this.psf = psf;
    }
  }
  public static void main(String[] args) throws Exception {
   Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int tar =  sc.nextInt();
    boolean[][] dp = new boolean[arr.length + 1][tar + 1];
    for
    (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        }
        else if (i == 0) {
          dp[i][j] = false;
        }
        else if (j == 0) {
          dp[i][j] = true;
        }
        else {
          if (dp[i - 1][j] == true) {
            dp[i][j] = true;
          }
          else {
            int val = arr[i - 1];
            if (j >= val && dp[i - 1][j - val] == true) {
              dp[i][j] = true;
            }
          }
        }
      }
    }

    System.out.println(dp[dp.length - 1][tar]);
    Queue< Pair> q = new ArrayDeque<>();
    q.add(new Pair(n, tar, ""));


    while (q.size() > 0) {
      Pair rem = q.poll();
      if (rem.i == 0 || rem.j == 0) {
        System.out.println(rem.psf);
      } else {
          if(rem.j>=arr[rem.i - 1]){ 
              boolean inc=dp[rem.i - 1][rem.j - arr[rem.i - 1]]
              if(inc) {
              q.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], (rem.i - 1) + " " + rem.psf));
            }
        }
         boolean exc = dp[rem.i - 1][rem.j];
        if (exc) {
          q.add(new Pair(rem.i - 1, rem.j, rem.psf));
        }
      }
    }
  }
}
