/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lpss-official/ojquestion
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int len=0;
        
        boolean [][]dp=new boolean[s.length()][s.length()];
        
        for(int g = 0; g<s.length(); g++){
            for(int i=0, j=g; j<dp.length; i++, j++){
                
                if(g == 0){
                    dp[i][j] = true;
                } else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    if(s.charAt(i) == s.charAt(j)&&  dp[i+1][j-1]==true){
                        dp[i][j] = true;
                        
                    }else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j] == true){
                    len = g+1;
                }
            }
        }
        System.out.println(len);

    }

}
