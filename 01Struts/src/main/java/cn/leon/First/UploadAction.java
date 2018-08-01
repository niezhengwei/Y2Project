package cn.leon.First;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by leon on 2018/6/13.
 */
public class UploadAction extends ActionSupport {
    private File upload;
    private String uploadFileName;  //文件名也必须定义为这个  因为是代码底层定义好的
    private String uploadContenType; //文件类型的名字必须是这个  底层定义好的属性名

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContenType() {
        return uploadContenType;
    }

    public void setUploadContenType(String uploadContenType) {
        this.uploadContenType = uploadContenType;
    }

    public String uploads(){
        System.out.println("进入文件上传方法");
        String path="E:\\upload";
        String realpath=path+ File.separatorChar+System.currentTimeMillis()+Math.random()+uploadFileName;
        System.out.println("路径为："+realpath);
        try {
            FileUtils.copyFile(upload,new File(realpath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

}
