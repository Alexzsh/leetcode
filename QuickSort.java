import java.util.*;

import javax.crypto.AEADBadTagException;

public class QuickSort {
    public static String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<names.length;++i){
            String name = names[i];
            if(!map.containsKey(name)){
                map.put(name, 1);
                res[i]=name;
                System.out.println("res i is "+name);
            }
            else {
                int now = map.get(name);
                name += "("+String.valueOf(now)+")";
                while(map.containsKey(name)){
                    name = name.substring(0,name.lastIndexOf("("));
                    map.put(name, now++);
                    name += "("+String.valueOf(now)+")";
                    System.out.println("map contains key update "+name);
                }
                map.put(name, 1);
                res[i]=name;
                System.out.println("res i is "+name);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // int[] arr = new int[] {9,4,6,8,3,10,4,6};
        // int[] arr2 = new int[] {9};
        // quickSort(arr,0,arr.length - 1);
        // arr=arr2;
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr2));
        // String[] arr = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
        // String[]  res =getFolderNames(arr);

        System.out.println(multiply("123456789", "987654321"));
        
    }
    public static String multiply(String num1, String num2) {
        System.out.println(num2=="0");
        if(num1=="0" || num2=="0") return "0";
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
            more=(newNum1.charAt(i)-'0'+newNum2.charAt(i)-'0'+more)/10;
            sb.append(addTemp);
            System.out.println(sb.toString()+"more is"+more);
        }
        if(more>0)
            sb.append(more);
        return sb.reverse().toString();
    }
    public static void quickSort(int[] arr,int low,int high) {
        int p,i,j,temp;
        
        if(low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= p && i < j) {
                j--;
            }
                            
            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）    
    
            //左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j) {
                i++;
            }
            
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p; 
        quickSort(arr,low,j-1);  //对左边快排
        quickSort(arr,j+1,high); //对右边快排
        
        }
    }
    