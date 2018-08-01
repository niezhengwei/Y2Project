package cn.leon.First;

import com.opensymphony.xwork2.ActionSupport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by leon on 2018/6/16.
 */
public class DowLoadAction extends ActionSupport {
    private  String download;  //文件所在路径

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private  String  fileName; //下载文件的名称
    private InputStream inputStream; //输入流对象


    public  String download() throws UnsupportedEncodingException, FileNotFoundException {
        try {
            inputStream=new FileInputStream(download);
            //E:\U1\cat.jpg
            fileName= download.substring(download.lastIndexOf("\\")+1);
            //解决中文乱码问题
            try {
                fileName= URLEncoder.encode(fileName,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  SUCCESS;
    }
}
