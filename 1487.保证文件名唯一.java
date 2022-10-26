import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1487 lang=java
 *
 * [1487] 保证文件名唯一
 */

// @lc code=start
class Solution {

    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<names.length;++i){
            String name = names[i];
            if(!map.containsKey(name)){
                map.put(name, 1);
                res[i]=name;
            }
            else {
                int now = map.get(name);
                name += "("+String.valueOf(now)+")";
                while(map.containsKey(name)){
                    name = name.substring(0,name.lastIndexOf("("));
                    
                    map.put(name, now+1);
                    name += "("+String.valueOf(now+1)+")";
                }
                map.put(name, 1);
                res[i]=name;
            }
        }
        return res;
    }
}
// @lc code=end

