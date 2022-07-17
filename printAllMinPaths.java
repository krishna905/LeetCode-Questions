/*

https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-jumps-re-official/ojquestion
*/


import java.util.*;

public class Main{
    
    public static class Pair{
        int i;
        int s;
        int j;
        String pathSF;
        Pair(int i, int s, int j, String pathSF){
            this.i=i;
            this.s=s;
            this.j=j;
            this.pathSF=pathSF;
        }
        
    }
    
    public static void Solution(int arr[]){
        // write your code here
        int n= arr.length;
         Integer dp[]=new Integer[n];
         
       
        dp[n-1]=0;
        
        for(int i=n-2;i>=0;i--){
            
            
                int min=Integer.MAX_VALUE;
                
                for(int j=1; j<=arr[i] && i+j < arr.length ; j++){
                    
                    if(dp[i+j]!=null){
                        min=Math.min(min, dp[i+j]);
                    }
                }
                if(min!=Integer.MAX_VALUE){
                    dp[i]=min+1;
                }
        }
            
           System.out.println(dp[0]);
            ArrayDeque<Pair> q = new ArrayDeque<>();
            q.add(new Pair(0,arr[0], dp[0], 0+""));
            
    while(!q.isEmpty()){
                Pair removed = q.removeFirst();
                
                 if(removed.j==0){
                    System.out.println(removed.pathSF + " .");
                 }
                
        for(int k=1; k<=removed.s && removed.i+k < arr.length; k++){
            
            int ci=removed.i+k;
            
            if(dp[ci]!=null && dp[ci] == removed.j-1){
                q.add(new Pair(ci, arr[ci], dp[ci], removed.pathSF+
                                          " -> "+ci));
            }
                    
                }
            }
        
        
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
       
    }
}


/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/minimum-cost-path-re-official/ojquestion

*/


import java.io.*;
import java.util.*;

public class Main {

  private static class Pair {
    String psf;
    int i;
    int j;

    public Pair(String psf, int i, int j) {
      this.psf = psf;
      this.i = i;
      this.j = j;
    }
  }

  public static void main(String[] args) throws Exception {
   Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    int m =  sc.nextInt();
    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] =  sc.nextInt();
      }
    }

    int [][]dp = new int[arr.length][arr[0].length];
        
       
        for(int i=dp.length-1; i>=0 ; i--){
            for(int j=dp[0].length-1 ; j>=0 ; j--){
                
                if(i==dp.length-1 && j==dp[0].length-1){
                        dp[i][j]=arr[i][j];
                }else if(i==dp.length-1){
                    dp[i][j]=arr[i][j]+dp[i][j+1];
                }else if(j==dp[0].length-1){
                    dp[i][j]=arr[i][j]+dp[i+1][j];         
                }else{
                    dp[i][j]=arr[i][j]+Math.min(dp[i][j+1], dp[i+1][j]);
                    
                }
            }
        }
        System.out.println(dp[0][0]);
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair("", 0, 0));
        
        while(!q.isEmpty()){
            Pair rem= q.pollFirst();
            
            if(rem.i ==  dp.length-1 && rem.j == dp[0].length-1){
                System.out.println(rem.psf);
                
            }else if(rem.i==dp.length-1){
                q.add(new Pair(rem.psf+"H", rem.i,rem.j+1));
                
            }else if(rem.j==dp[0].length-1){
                q.add(new Pair(rem.psf+"V", rem.i+1,rem.j));
                
            }else{
                if(dp[rem.i+1][rem.j] < dp[rem.i][rem.j+1]){
                    q.add(new Pair(rem.psf+"V", rem.i+1,rem.j));
                    
                }else if(dp[rem.i+1][rem.j] > dp[rem.i][rem.j+1]){
                    q.add(new Pair(rem.psf+"H", rem.i,rem.j+1));
                    
                }else{
                     q.add(new Pair(rem.psf+"V", rem.i+1,rem.j));
                     q.add(new Pair(rem.psf+"H", rem.i,rem.j+1));
                    
                }
                
            }
            
        }

  }

}
