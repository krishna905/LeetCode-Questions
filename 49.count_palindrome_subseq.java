/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/cps-official/ojquestion

this includes permutation-----> bccb --> b , b, c, c, bcb, bcb, cc, bb, bccb
*/



import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);
    String s = scn.nextLine();
     int dp[][]=new int[s.length()][s.length()];
            
            for(int g=0; g<s.length();g++){
                
                for(int i=0, j=g; j<s.length();i++, j++){
                    
                    if(g==0){
                        dp[i][j]=1;
                    }else if(g==1){
                        if(s.charAt(i) == s.charAt(j)){
                            dp[i][j]=3;
                        } else{
                            dp[i][j]=2;
                        }

                    }else{
                        if(s.charAt(i) == s.charAt(j)){
                            dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1;

                        }else{
                            dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                        }

                    }
                }
            }
        System.out.println(dp[0][s.length()-1]);

}
}
