/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-many-colors-official/ojquestion
*/
//tc n^2

import java.util.*;


 class Main{
   
     public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();

    int[][] arr = new int[n][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    int[][] dp = new int[arr.length][arr[0].length];
   
        
        int least=Integer.MAX_VALUE;
        int sleast=Integer.MAX_VALUE;
       

        for(int i=0;i<arr[0].length;i++){
            dp[0][i]=arr[0][i];

            if(least>=arr[0][i]){
                sleast=least;
                least=arr[0][i];
            }else if(sleast>=arr[0][i]){
                sleast=arr[0][i];

            }
        }

        for(int i=1;i<arr.length;i++){
            int nleast=Integer.MAX_VALUE;
            int nsleast=Integer.MAX_VALUE;

            for(int j=0;j<arr[0].length;j++){

                if(least==dp[i-1][j]){
                    dp[i][j]=sleast+arr[i][j];
                }else {
                    dp[i][j]=least+arr[i][j];
                }
            
                if(nleast>=dp[i][j]){
                    nsleast=nleast;
                    nleast=dp[i][j];
                }else if(nsleast>=dp[i][j]){
                    nsleast=dp[i][j];

                }
            }
            least=nleast;
            sleast=nsleast;
        }
        System.out.println(least);
     }  
 }
