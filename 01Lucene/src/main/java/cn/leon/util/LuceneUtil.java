package cn.leon.util;

import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;

import java.io.IOException;

/**
 * Created by Happy on 2017-12-01.
 */
//LuceneUtil工具类
public class LuceneUtil {
    //1.索引写入器   方法区（静态存储区）
    private static IndexWriter indexWriter; //真实的项目中，咱们的indexWriter在整个项目中只能有一个，使用静态成员的方式来解决
    //2.索引搜索对象
    private static IndexSearcher indexSearcher;
    static {
        //写入器配置
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Configuration.getAnalyzer());
        //合并工具
        LogMergePolicy mergePolicy = new LogByteSizeMergePolicy();
        //达到3个文件时就和合并 ,当索引库中索引文件数达到3个的时候自动合并
        mergePolicy.setMergeFactor(3);
        indexWriterConfig.setMergePolicy(mergePolicy);
        try {
            indexWriter=new IndexWriter(Configuration.getDirectory(),indexWriterConfig);
          /*  //读取器
            IndexReader indexReader= DirectoryReader.open(Configuration.getDirectory());
            //构建IndexSearcher
            indexSearcher=new IndexSearcher(indexReader);*/
            System.out.println("已经初始化");
            //指定在jvm退出前要执行的代码
            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run() {
                    closeIndexWriter();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static IndexWriter getIndexWriter() {
        return indexWriter;
    }
   //关闭indexWriter
    public static void closeIndexWriter(){
        if (indexWriter!=null){
            try {
                indexWriter.close();
                System.out.println("已经关闭indexWriter");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通知一下索引库更改了
     */
    public static void indexChanged(){
        if (indexSearcher!=null){
            IndexReader indexReader= null;
            try {
                indexReader = DirectoryReader.open(Configuration.getDirectory());
                indexReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            indexSearcher=null;
        }
    }

//http://www.gitbook.net/lucene/lucene_search_operation.html
    public static IndexSearcher getIndexSearcher() {
        if (indexSearcher==null){ //发现索引器检索器为null
            try{
                IndexReader indexReader= DirectoryReader.open(Configuration.getDirectory());
                indexSearcher=new IndexSearcher(indexReader);
            }catch (Exception ex){
                throw new RuntimeException();
            }
        }
        return indexSearcher;
    }
}
