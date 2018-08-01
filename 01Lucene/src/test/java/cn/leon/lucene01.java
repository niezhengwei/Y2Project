package cn.leon;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by leon on 2018/7/14.
 */
public class lucene01 {

    public String dir="F:\\data";

    /**
     * 创建索引库
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        Path path= Paths.get("./article/");
        Directory directory= FSDirectory.open(path);
        IndexWriterConfig config=new IndexWriterConfig();
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter writer=new IndexWriter(directory,config);
        File file=new File(dir);
        File[] files = file.listFiles();
        for (File item:files) {
            Document document=new Document();
            String filename=item.getName();
            String fileContent= FileUtils.readFileToString(item);
            long lastModifed=item.lastModified();
            document.add(new TextField("filename",filename, Field.Store.YES));
            document.add(new TextField("fileContent",fileContent, Field.Store.YES));
            document.add(new NumericDocValuesField("lastModifed",lastModifed));
            writer.addDocument(document);
            }
            writer.close();
        System.out.println("添加索引库成功");
        }

    /**
     * 检索索引库
     */
    @Test
        public void test02() throws IOException, ParseException {
        Path path=Paths.get("./luceneIndex/");
        Directory directory=FSDirectory.open(path);
        IndexReader reader= DirectoryReader.open(directory);
        IndexSearcher searcher=new IndexSearcher(reader);
        String num="io";
        QueryParser parser=new QueryParser("filename",new StandardAnalyzer());
        Query query = parser.parse(num);
        TopDocs topDocs = searcher.search(query,10 );

        long totalHits = topDocs.totalHits;
        System.out.println(totalHits);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc item : scoreDocs) {
            int nums=item.doc;
            Document document = reader.document(nums);
            String filename = document.get("filename");
            System.out.println(filename);

        }
    }
    }
