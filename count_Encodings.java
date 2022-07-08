/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-encodings-official/ojquestion
example 21123

*/



import java.io.*;

import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int[] dp = new int[str.length()];

    dp[0] = 1;
    for (int i = 1; i < str.length(); i++) {
      
      if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {      //if last two bits are 00...ther is no alphabet with 00 as ascii
        dp[i] = 0;
      } 
      else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {   //if 03 04 06...u have to mingle with last but one bit
        dp[i] = dp[i - 1];
      } 
      else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {  //if 20 30 60...u have to check whther number is greater than last ascii value..i.e, 26.
        if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {  
          dp[i] = (i >= 2 ? dp[i - 2] : 1);
        }
      } 
      
      else {
        dp[i] = dp[i - 1];
        if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
          dp[i] += (i >= 2 ? dp[i - 2] : 1);
        }
      }
    }
    System.out.println(dp[str.length() - 1]);
    scn.close();
  }
}
