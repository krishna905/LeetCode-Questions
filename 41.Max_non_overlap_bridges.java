
/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/max-non-overlapping-bridges-official/ojquestion
*/





import java.io.*;
import java.util.*;

public class Main {
    public static class Bridge implements Comparable<Bridge>{
        int n;
        int s;
        
        Bridge(int n, int s){
            this.n=n;
            this.s=s;
        }
        
        public int compareTo(Bridge o){
            if(this.n!=o.n)
            return this.n-o.n;
            else
            return this.s-o.s;
        }
        
    }
  //needed to sort the north banks and compare using lis... if any of two north banks are of equal value, sort accoding to south values

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        
        Bridge bdg[]=new Bridge[size];
        
        for(int i=0;i<size;i++){
            int n=sc.nextInt();
            int s=sc.nextInt();
            bdg[i]= new Bridge(n,s);
        }
        Arrays.sort(bdg);
        
        int dp[]=new int[size];
        int omax=0;
        
        for(int i=0;i<size;i++){
            
            int max=0;
            for(int j=0;j<i;j++){
                
                if(bdg[i].s>=bdg[j].s){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            
            if(dp[i]>omax){
                omax=dp[i];
            }
        }
        System.out.println(omax);
}

        
        
        
        
    }

