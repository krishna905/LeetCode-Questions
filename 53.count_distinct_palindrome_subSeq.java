/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-of-distinct-palindromic-subsequences-official/ojquestion
*/



import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s) {
		// write your code here
		int dp[][] =  new int[s.length()][s.length()];
		
		int prev[] = new int[s.length()];
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++){
		    char ch = s.charAt(i);
		    
		    if(!map.containsKey(ch)){
		        prev[i] = -1;
		    } else{
		        prev[i] = map.get(ch);
		    }
		    map.put(ch, i);
		}
		
		int next[] = new int[s.length()];
		map.clear();
		
		for(int i = s.length()-1; i >= 0; i--){
		    char ch = s.charAt(i);
		    
		    if(!map.containsKey(ch)){
		        next[i] = -1;
		    }else{
		        next[i] = map.get(ch);
		    }
		    map.put(ch, i);
		}
		
		for(int g = 0; g < s.length(); g++){
		    for(int i = 0,j=g; j < dp.length; i++, j++){
		        
		        if(g == 0){
		            dp[i][j] = 1;
		        } else if(g == 1){
		            dp[i][j] = 2;
		        
		          } else{
		              char ch1 = s.charAt(i);
		              char ch2 = s.charAt(j);
		              
		            if(ch1 != ch2){
		              dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
		              } else{
		                  int nIdx = next[i];
		                  int pIdx = prev[j];
		                  
		                  if(nIdx > pIdx){
		                      dp[i][j] = 2*dp[i+1][j-1] + 2;
		                      
		                  } else if(nIdx == pIdx){
		                      dp[i][j] = 2*dp[i+1][j-1] + 1;
		                      
		                  } else{
		                      dp[i][j] = 2*dp[i+1][j-1] - dp[nIdx + 1][pIdx - 1];
		                      
		                  }
		              }
		          }
		}
		}
		return dp[0][s.length()-1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
