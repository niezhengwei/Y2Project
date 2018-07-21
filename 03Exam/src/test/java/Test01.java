/**
 * Created by leon on 2018/7/21.
 */

import java.io.UnsupportedEncodingException;

/**
 * 1).编写一个截取字符串的函数，输入为一个字符串和字节数，
 * 输出为按字节截取的字符串，但要保证汉字不被截取半个，
 * 如“我ABC”，4，应该截取“我AB”，输入“我ABC汉DEF”，6，应该输出“我ABC”，
 * 而不是“我ABC+汉的半个”。
 */
public class Test01 {
    public static void main(String[] args) {
        String str = splitString("我ABC", 4);
        System.out.println(str);

    }
    public static  String splitString(String str,int count){
        //将一个字符看成一个数组
        char[] chars = str.toCharArray();
        //声明一个Int类型变量  保存字节数
        int sum=0;
        StringBuilder builder=new StringBuilder();
        //ASC码表范围0-128 没有中文  都是单字节字符  遍历字符数组中的每一项
        for (char item : chars) {
            //如过item大于了128就是双字节字符  那么sum保存的总字节数就为2
            if ((int)item>=128){
                sum+=2;
            }else{  //否则就是单字节 sum就++  sum就为1
                sum++;
            }
            //如果保存的字节数大于或者等于了输入的字节数，就退出
            if(sum>=count){
                break;
            }
            builder.append(item);
        }
        return builder.toString();
    }


}
