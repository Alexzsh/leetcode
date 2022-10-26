import java.util.LinkedList;
import java.util.List;

import javax.naming.LinkException;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        
        int i=0,j=0,m=matrix.length,n=matrix[0].length,change_flag=0;
        int left=0,right=n-1,up=0,down=m-1;
        while(res.size()<m*n){
            res.add(matrix[i][j]);
            if(change_flag==0 && j==right){
                change_flag++;
                up++;
            }
            else if(change_flag==1 && i==down){
                change_flag++;
                right--;
            }
            else if(change_flag==2 && j==left){
                change_flag++;
                down--;
            }
            else if(change_flag==3 && i==up){
                change_flag++;
                left++;
            }
            change_flag%=4;
            i+=direction[change_flag][0];
            j+=direction[change_flag][1];
        }
        return res;
    }
}
// @lc code=end

