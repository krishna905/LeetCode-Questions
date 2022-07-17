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


/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/zero-one-knapsack-re-official/ojquestion

printing paths of knapsack
*/




import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair{
        int i;
        int j;
        String psf;
        Pair(int i, int j, String psf){
            this.i=i;
            this.j=j;
            this.psf=psf;
        }
    }

    public static void main(String[] args) throws Exception {
       Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        int[] values = new int[n];
       
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int[] wts = new int[n];
      
        for (int i = 0; i < n; i++) {
            wts[i] =sc.nextInt();
        }

        int cap = sc.nextInt();

        //write your code here
        int dp[][]=new int[n+1][cap+1];
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]= dp[i-1][j];
                
                if(j>=wts[i-1]){
                    if(dp[i-1][j-wts[i-1]]+ values[i-1] > dp[i-1][j]){
                        dp[i][j]= dp[i-1][j-wts[i-1]]+ values[i-1];
                    }
                }
            }
        }
        int ans= dp[dp.length-1][dp[0].length-1];
        System.out.println(ans);
        ArrayDeque<Pair> q= new ArrayDeque<>();
        
        q.add(new Pair(dp.length-1, dp[0].length-1, ""));
        
        while(!q.isEmpty()){
            Pair rem = q.pollFirst();
            
            if(rem.i==0 || rem.j==0){
                System.out.println(rem.psf);
            }else{
                int exc =  dp[rem.i-1][rem.j];
                if(rem.j>=wts[rem.i-1]){
                int inc = dp[rem.i-1][rem.j-wts[rem.i-1]] + values[rem.i-1];
                
                if(dp[rem.i][rem.j] ==  inc){
                    q.add(new Pair(rem.i-1, rem.j-wts[rem.i-1], (rem.i-1)+" "+rem.psf));
                }
                }
                
                  if(dp[rem.i][rem.j] ==  exc){
                    q.add(new Pair(rem.i-1, rem.j, rem.psf+" " ));
                }
            }
        }
        
    }
}


                        


                        


                        
