/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */

// @lc code=start
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity)
            return false;
        if(jug1Capacity==0||jug2Capacity==0){
            return targetCapacity==0 || targetCapacity==jug1Capacity+jug2Capacity;
        }  

        return targetCapacity%gcd(jug1Capacity, jug2Capacity)==0;   
    }
    public int gcd(int a,int b){
        int x = a%b ;
        while(x!=0){
            a = b;
            b = x;
            x = a%b;
        }
        return b;
    }

}
// @lc code=end

