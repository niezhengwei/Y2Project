package cn.leon;

import cn.leon.entity.Article;
import cn.leon.util.AritcleDocumentUtils;
import cn.leon.util.Configuration;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.search.highlight.Scorer;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2018/7/20.
 */
public class lucene02 {

    /**
     * 高量
     */
    @Test
    public  void test01() throws IOException, ParseException, InvalidTokenOffsetsException {
        String word="我";
        //搜索使用的API
        IndexReader reader= DirectoryReader.open(Configuration.getDirectory());
        IndexSearcher searcher=new IndexSearcher(reader);
        QueryParser parser=new QueryParser("content",Configuration.getAnalyzer());
        Query query = parser.parse(word);

        //创建一个高亮显示器
        Formatter formatter=new SimpleHTMLFormatter("<font color='red'>","</font>");
        //设置一个Scorer对象 给HighLight做铺垫
        Scorer scorer=new QueryScorer(query,"content");
        Sort sort=new Sort(new SortField("Sorttitle",SortField.Type.STRING,false));
        //通过serach获取到检索结果
        TopDocs search = searcher.search(query, 100,sort);
        //所有文档的集合
        ScoreDoc[] scoreDocs = search.scoreDocs;
        //获取到Highlighter对象
        Highlighter highlighter=new Highlighter(formatter,scorer);
        //设置显示的字符数
        Fragmenter fragmenter=new SimpleFragmenter(20);
        highlighter.setTextFragmenter(fragmenter);
        List<Article> list=new ArrayList<Article>();
        for (ScoreDoc item : scoreDocs) {
            int doc = item.doc;
            Document document = reader.document(doc);
            //获取到最佳匹配字段
            String bestFragment = highlighter.getBestFragment(Configuration.getAnalyzer(), "content", document.get("content"));
            System.out.println(bestFragment+"------------");
            ((Field)document.getField("content")).setStringValue(bestFragment);
            Article article = AritcleDocumentUtils.documentToArticle(document);
            list.add(article);
        }
        for (Article items:list) {
            System.out.println(items.getContent());
        }
    }

}
