package cn.leon.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Happy on 2017-11-30.
 * 配置类
 */
public class Configuration {
    //1.目录对象
    private static Directory directory;
    //2.分词器对象
    private static Analyzer analyzer;
    //静态代码块
    static {
        //初始化所有配置，应通过配置文件得到配置的值
        Path path = Paths.get("./article/");
        try {
            //索引库
            directory=FSDirectory.open(path);
            analyzer=new StandardAnalyzer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Directory getDirectory() {
        return directory;
    }

    public static void setDirectory(Directory directory) {
        Configuration.directory = directory;
    }

    public static Analyzer getAnalyzer() {
        return analyzer;
    }

    public static void setAnalyzer(Analyzer analyzer) {
        Configuration.analyzer = analyzer;
    }


}
