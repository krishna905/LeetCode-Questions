/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-palindromic-cut-official/ojquestion
*/




import java.io.*;
import java.util.*;

public class Main {

	public static int minPalindromicCut(String s) {
		//write your code here
		boolean [][]dp=new boolean[s.length()][s.length()];
		
		for(int g=0;g<s.length();g++){
		    for(int i=0, j=g; j<s.length();i++,j++){
		        
		        if(g==0){
		            dp[i][j]=true;
		        }else if(g==1){
		            dp[i][j]=s.charAt(i)==s.charAt(j);

		        }else{
		            if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]== true){
		                dp[i][j]=true;
		            }else{
		                dp[i][j]=false;
		            }
		        }
		    }
		}
		
		int store[]=new int[s.length()];
		store[0]=0;
		
		//suffix checking from back
		for(int j = 1; j < store.length; j++){
		    
		    //if given whole string is palindrome
		    if(dp[0][j] == true){
		        store[j] = 0;
		    } else{
		        int min=Integer.MAX_VALUE;
		    
    		    for(int i = j; i >= 1;i--){
    		        
    		        if(dp[i][j] == true){
    		            if(store[i-1] < min)
    		              min = store[i-1];
    		        }
    		        
    		    }
    		    store[j] = min+1;
    		    
    		}
		}
		return store[store.length-1];
		
	/*	int store[][]=new int[s.length()][s.length()];
		
		for(int g=0;g<s.length();g++){
		    for(int i=0, j=g;j<store.length;i++,j++){
		        
		        if(g==0){
		            store[i][j]=0;
		        }else if(g==1){
		            if(s.charAt(i) == s.charAt(j))
		               store[i][j]=0;
		            else
		               store[i][j]=1;
		        }else{
		            if(dp[i][j]==true)
		              store[i][j]=0;
		            else{
		                int min=Integer.MAX_VALUE;
		                for(int k=i;k<j;k++){
		                    int left = store[i][k];
		                    int right = store[k+1][j];
		                    
		                    if(left+right+1 < min){
		                        min= left+right+1;
		                    }
		                }
		                store[i][j]=min;
		                
		            }
		            
		        }
		    }
		}

		return store[0][store.length-1];*/
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}
