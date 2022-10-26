import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public static String multiply(String num1, String num2) {
        if(num1=="0" || num2=="0") return"0";
        List<String> all = new LinkedList<>();
        for(int i=num2.length()-1;i>=0;--i){
            all.add(mul(num1, num2.charAt(i), num2.length()-1-i));
        }
        System.out.println(all);
        String res="";
        for(int i=0;i<all.size();++i){
            res = add(res,all.get(i));
            System.out.println(res);
        }
        return res;
    }
    public static String mul(String num1,char num2,int index){
        StringBuilder sb = new StringBuilder();
        while(index-->0)
            sb.append("0");
        int more=0;
        for(int i=num1.length()-1;i>=0;--i){
            int addTemp= ((num1.charAt(i)-'0')*(num2-'0')+more)%10;
            more=((num1.charAt(i)-'0')*(num2-'0')+more)/10;
            sb.append(addTemp);
        }
        if(more>0)
            sb.append(more);
        return sb.reverse().toString();
    }
    public static String add(String num1,String num2){
        if(num1.length()==0) return num2;
        if(num2.length()==0) return num1;
        String pre = "0".repeat(Math.abs(num1.length()-num2.length()));
        String newNum1 = num1.length()<num2.length()?pre+num1:num1;
        String newNum2 = num2.length()<num1.length()?pre+num2:num2;
        System.out.println(num1+"_"+num2+"_"+pre.toString());
        System.out.println(newNum1+"_"+newNum2);
        StringBuilder sb = new StringBuilder();
        int more=0;
        for(int i=newNum2.length()-1;i>=0;--i){
            int addTemp=(newNum1.charAt(i)-'0'+newNum2.charAt(i)-'0'+more)%10;
            more=(newNum1.charAt(i)-'0'+newNum2.charAt(i)-'0')/10;
            sb.append(addTemp);
            System.out.println(sb.toString()+"more is"+more);
        }
        if(more>0)
            sb.append(more);
        return sb.reverse().toString();
    }
}
// @lc code=end

