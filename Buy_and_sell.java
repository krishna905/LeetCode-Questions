/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ota-official/ojquestion
one trasaction i.e., 1 buy and 1 sell
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int leastPrice=Integer.MAX_VALUE;
        int oldPro=0;
        int todayPro=0;
        
        for(int i=0;i<n;i++){
            if(arr[i]<leastPrice){
                leastPrice=arr[i];
            }
            todayPro=arr[i]-leastPrice;
            
            if(todayPro > oldPro){
                oldPro= todayPro;
            }
        }
        System.out.println(oldPro);
    }

}



/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ita-official/ojquestion
Infinite transactions of buy and sell
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            
        }
        int profit=0;
        int sdate=0;
        int bdate=0;
        
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                sdate++;
            }else{
                profit+=arr[sdate]-arr[bdate];
                sdate=bdate=i;
            }
        }
         profit+=arr[sdate]-arr[bdate];
         System.out.println(profit);
    }

}
