/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-distinct-subsequences-official/ojquestion
*/



import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        
        //write your code here
        long dp[] = new long[s.length() + 1];
        
        dp[0] = 1;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 1; i < dp.length; i++){
            char ch = s.charAt(i - 1);
            
             dp[i] = 2 * dp[i - 1];
            
            if(map.containsKey(ch)){
                int idx = map.get(ch);
                
                dp[i] = dp[i] - dp[idx - 1];
                
            }
            map.put(ch,i);
        }
        System.out.println(dp[s.length()]-1);

    }
}


/*
-----------if string length is large, use long dp....if very large use mod---------------
 int mod = 1_000_000_007;
    public int distinctSubseqII(String s) {
        
         int dp[] = new int[s.length() + 1];
        
        dp[0] = 1;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 1; i < dp.length; i++){
            char ch = s.charAt(i - 1);
            
             dp[i] = (2 * dp[i - 1]) % mod;
            
            if(map.containsKey(ch)){
                int idx = map.get(ch);
                
                dp[i] = (dp[i] - dp[idx - 1] + mod) % mod;
                
            }
            map.put(ch,i);
        }
        int res = dp[s.length()]-1;
        res = res % mod;
        return res;
        */
