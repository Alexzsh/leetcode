
/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution1 {
    public String longestPalindrome(String s) {
        // String  res="";
        // for(int i=0;i<s.length();++i){
        //     String s1 = isPalindrome(s, i, i);
        //     String s2 = isPalindrome(s, i, i+1);
        //     res = res.length()>s1.length()?res:s1;
        //     res = res.length()>s2.length()?res:s2;
            
        // }
        // return res;
        return lP(s);
    }
    public String lP(String s ){
        return LCS(s, new StringBuffer(s).reverse().toString());
    }
    public String LCS(String s1,String s2){
        int[][] dp = new int[s1.length()][s2.length()];
        int maxLen=0,maxEnd=0;
        for(int i=0;i<s1.length();++i){
            for(int j=0;j<s2.length();++j){
                if(s1.charAt(i)==s2.charAt(j)){
                    if(i==0||j==0) dp[i][j]=1;
                    else dp[i][j]=dp[i-1][j-1]+1;
                }
                if(dp[i][j]>maxLen){
                    int before = s1.length()-1-j;
                    if(before+dp[i][j]-1==i){
                        maxLen=dp[i][j];
                        maxEnd=i;
                    }
                    
                }
            }
        }
        return s1.substring(maxEnd-maxLen+1,maxEnd+1);
    }
    public String isPalindrome(String s ,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
        return s.substring(l+1, r);
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int maxStart=0,maxEnd=0;
        for(int i=0;i<s.length();++i){
            int l1 = palindrome(s,i,i);
            int l2 = palindrome(s,i,i+1);
            int maxlen = Math.max(l1,l2);
            if(maxlen>maxEnd-maxStart){
                maxStart=i-(maxlen-1)/2;
                maxEnd = i+maxlen/2;
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }
    public int palindrome(String s ,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    
}
// @lc code=end

