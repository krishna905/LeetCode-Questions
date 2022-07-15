/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/highway-billboard-official/ojquestion
*/


import java.util.*;
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
        // write your code here
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<x.length;i++){
            map.put(x[i], rev[i]);
        }
      
        //dp is length of highway
      
        int dp[]=new int[m+1];
        dp[0]=0;
        for(int i=1;i<=m;i++){
            if(!map.containsKey(i)){
                dp[i]=dp[i-1];
            }else{
                
                int nearBoard=dp[i-1];
                int curBoard=map.get(i);
                
                if(i>=t+1){
                    curBoard+=dp[i-t-1];
                    
                }
                dp[i]=Math.max(nearBoard, curBoard);
            }
            
        }
        
        return dp[m];
      
    //-------------------------another approach---------------------------------------------------------------------------
      
      /*
      // here dp is length of boards
       int dp[]=new int[x.length];
        dp[0]=rev[0];
        int ans=0;
        
        for(int i=1;i<dp.length;i++){
            int max=0;
            
            for(int j=0;j<i;j++){
                int dist = x[i] - x[j];
                if(dist > t){
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp[i]=max+rev[i];
            ans=Math.max(ans, dp[i]);
        }
        
             return ans;
    }
      */
    }
   
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
      
        for(int i=0;i<n;i++){
          x[i]=scn.nextInt();
        }

        int revenue[] = new int[n];
        for(int i=0;i<n;i++){
          revenue[i]=scn.nextInt();
        }

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}
