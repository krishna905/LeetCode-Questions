/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/russian-doll-envelopes-official/ojquestion
*/


import java.io.*;
import java.util.*;

public class Main {
    public static class Envelope implements Comparable<Envelope>{
        int w;
        int h;
        
        Envelope(int w, int h){
            this.w=w;
            this.h=h;
        }
        public int compareTo(Envelope o){
            return this.w-o.w;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        Envelope env[]=new Envelope[n];
        
        for(int i=0;i<n;i++){
            int w=sc.nextInt();
            int h= sc.nextInt();
            env[i]=new Envelope(w,h);
        }
        Arrays.sort(env);
        
        int dp[]=new int[n];
        int omax=0;
        
        for(int i=0;i<n;i++){
            
            int max=0;
            for(int j=0;j<i;j++){
                
                if(env[j].h < env[i].h  ){
                    if(dp[j] > max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            if(dp[i] > omax){
                omax=dp[i];
            }
        }
        System.out.println(omax);
        
    }

}
