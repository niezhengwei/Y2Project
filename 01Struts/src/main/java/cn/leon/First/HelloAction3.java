package cn.leon.First;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by leon on 2018/6/11.
 */
public class HelloAction3  extends ActionSupport{
    public static void main(String[] args)
    {
        int i=0;
        int j=0;
        for(i=1;i<=9;i++)
        { for(j=1;j<=i;j++)
            System.out.print(i+"*"+j+"="+i*j+"\t");
            System.out.println();
        }
    }
}
