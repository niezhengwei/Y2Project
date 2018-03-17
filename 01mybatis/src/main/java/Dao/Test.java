package Dao;

/**
 * Created by leon on 2018/3/10.
 */
public class Test {
    public static void main(String[] args) {
        String s = GetTrimHtml("<html><body>4<5</body></html>");
        System.out.println(s);
    }
    public static String GetTrimHtml(String strInput){
        String[] ss=strInput.split("");
        String result=strInput;
        //声明一个起始位置  值为-1
        int begin=-1;
        for (int i=0;i<strInput.length();i++) {
            if(ss[i].equals("<")){
                begin=i;//如果i的值检测为<，就将i的值赋给begin  作为起始位置检测
            }
            if(ss[i].equals(">")&&begin!=-1){
                result=result.replace(strInput.substring(begin,i+1),"");
                begin=-1;
            }
        }
        return result;
    }
}
