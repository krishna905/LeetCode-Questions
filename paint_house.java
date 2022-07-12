/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-official/ojquestion
*/




import java.util.*;


 class Main{
   
     public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
          int [][]arr= new int[n][3];
         for(int i=0;i<n;i++){
             for(int j=0;j<3;j++){
                 arr[i][j]=sc.nextInt();
             }
         }
         int red=arr[0][0];
         int blue=arr[0][1];
         int green=arr[0][2];

         for(int i=1;i<n;i++){
             int newR= arr[i][0]+Math.min(green , blue);
             int newB= arr[i][1]+Math.min(red,green);
             int newG= arr[i][2]+ Math.min(red, blue);

             red=newR;
             blue=newB;
             green=newG;
         }
         int res= Math.min(red, Math.min(green, blue));
         System.out.println(res);
         
         
   
     }
 }

//if i take red now, i shouldnt take previous paint as red, so chooosing mininmum from previous paints


/*




 int[][] dp = new int[n][3];                   
    dp[0][0] = arr[0][0];
    dp[0][1] = arr[0][1];                         
    dp[0][2] = arr[0][2];


    for (int i = 1; i < n; i++) {                 
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
      dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + arr[i][2];
    }
    System.out.println(Math.min(dp[n - 1][0], (Math.min(dp[n - 1][1], dp[n - 1][2]))));
    //5
  }
}


*/
