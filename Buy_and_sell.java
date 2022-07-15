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


/*
https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-transaction-fee-ita-official/ojquestion
Infinite transactions with fee per every transaction




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        
        int fee=sc.nextInt();
        
        int ptillB=-arr[0];
        int ptillS=0;
        
        for(int i = 1; i < n; i++){
            int nptillB=0;
            int nptillS=0;
            
            
            if(ptillS-arr[i] > ptillB){
                nptillB = ptillS-arr[i];
            }else{
                nptillB = ptillB;
            }
            
            
            if(arr[i]+ptillB - fee > ptillS){
                nptillS = arr[i]+ptillB - fee;
            }else{
                nptillS = ptillS;
            }
            
            
            ptillS = nptillS;
            ptillB = nptillB;
        }
        System.out.println(ptillS);
        
    }

}


/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/

infinite transactions but 1 day gap for every transacation
*/

class Solution {
    public int maxProfit(int[] prices) {
        int ptillB=-prices[0];
        int ptillS=0;
        int ptillC=0;
        
        for(int i=01;i<prices.length;i++){
            int nptillB=0;
            int nptillS=0;
            int nptillC=0;
            
            if(ptillC-prices[i] > ptillB){
                nptillB= ptillC-prices[i];
            }else{
                nptillB = ptillB;
            }
            
            if(ptillB + prices[i] > ptillS){
                nptillS = ptillB + prices[i];
            }else{
                nptillS = ptillS;
            }
            
            if(ptillS > ptillC){
                nptillC = ptillS;
            }else{
                nptillC = ptillC;
            }
            
            
            ptillB=nptillB;
            ptillS=nptillS;
            ptillC=nptillC;
            
            
            
     }
        return ptillS;
        
        
        
        
    }
}
