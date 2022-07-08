import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int zeroes = 1;
    int ones = 1;
    for (int i = 2; i <= n; i++) {
      int nzeroes = ones;
      int nones = ones + zeroes;

      zeroes = nzeroes;
      ones = nones;
    }

    System.out.println(zeroes + ones);
  }

}


/*
int dp1[]=new int[n+1];
int dp2[]=new int[n+1];

dp0[1]=1;
dp1[1]=1;
for(int i=2;i<=n;i++){
  dp0[i]=dp1[i-1];
  dp1[i]=dp0[i-1]+dp1[i-1];
  }
  System.out.println(dp1[n]+dp0[n]);
*/
