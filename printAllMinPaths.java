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
