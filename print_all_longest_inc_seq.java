/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lis-re-official/ojquestion
*/



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static class Pair{
        int idx;
        int len;
        int val;
        String psf;
        Pair(int idx, int len, int val, String psf){
            this.idx=idx;
            this.len=len;
            this.val=val;
            this.psf=psf;
        }
    }
    
        
    public static void solution(int []arr){
       
        
        int omax = 0;
       
        int[]dp = new int[arr.length];
        
            for(int i = 0; i < dp.length; i++) {
                int max = 0;
                for(int j = 0; j < i; j++){
                  
                  if (arr[j] <= arr[i]){
                     if (dp[j] > max){
                     max = dp[j];
                     }
                    }
                }
              
                 dp[i] = max + 1;
                 if(dp[i] > omax) {
                    omax = dp[i];
                   
                }
            }
       System.out.println(omax);
       
       ArrayDeque<Pair> q=new ArrayDeque<>();
       
      for(int i=0;i<dp.length;i++){
           if(omax==dp[i])
          q.add(new Pair(i,omax, arr[i], arr[i]+""));
       }
       
       while(!q.isEmpty()){
           Pair rem= q.pollFirst();
           
           if(rem.len == 1){
               System.out.println(rem.psf);
           }
           
           for(int j=rem.idx-1;j>=0;j--){
               if(dp[j]==rem.len-1 && arr[j]<=rem.val){
                    q.add(new Pair(j,dp[j], arr[j], arr[j]+" -> "+rem.psf));
                   
                   
               }
               
           }
       }
       
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

       
    }
}
