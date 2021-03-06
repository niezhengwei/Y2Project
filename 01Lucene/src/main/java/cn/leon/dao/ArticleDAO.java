package cn.leon.dao;

import cn.leon.entity.Article;
import cn.leon.entity.SearchResult;
import cn.leon.util.AritcleDocumentUtils;
import cn.leon.util.Configuration;
import cn.leon.util.LuceneUtil;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Happy on 2017-11-30.
 */
public class ArticleDAO {

    public ArticleDAO() {
    }

    /**
     * 建立索引
     * @param article
     */
    public void save(Article article){
        Document doc= AritcleDocumentUtils.articleToDocument(article);
        //保存到索引库中
        try {
            LuceneUtil.getIndexWriter().addDocument(doc);  //建立索引
            LuceneUtil.getIndexWriter().commit();//提交
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 删除索引
     * @param id
     */
    public void delete(Integer id){
        try {
            //Term
            Term term=new Term("id",id.toString());
            IndexWriter writer=null;
            LuceneUtil.getIndexWriter().deleteDocuments(term);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 更新索引
     * @param article
     */
    public void update(Article article){
        try {
            Term term=new Term("id",article.getId().toString());
            Document document = AritcleDocumentUtils.articleToDocument(article);
            LuceneUtil.getIndexWriter().updateDocument(term,document);//更新索引，就是先删除，再创建
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param queryString 检索的条件  就业
     * @param firstResult  其实的记录编 号
     * @param maxResult  每页的数据量  ES:   Lucene ：
     *                   search（0,10）   search（10,10）  search（20,10）
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public SearchResult<Article> search(String queryString, int firstResult, int maxResult) throws ParseException, IOException {
        //默认在title 与 Content中搜索
        QueryParser queryParser=new MultiFieldQueryParser(new String[]{"title","content"}, Configuration.getAnalyzer());
        Query query=queryParser.parse(queryString);
        //执行查询，得到中间结果
        //IndexReader indexReader=DirectoryReader.open(Configuration.getDirectory());
        IndexSearcher indexSearcher=LuceneUtil.getIndexSearcher();

        TopDocs topDocs = indexSearcher.search(query, firstResult+maxResult);
        int count= (int) topDocs.totalHits;//总结果数
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        List<Article> list=new ArrayList<Article>();
        //结束索引
        int endIndex=Math.min(firstResult+maxResult,scoreDocs.length);
        for (int i=firstResult;i<endIndex;i++){
            ScoreDoc scoreDoc=scoreDocs[i];
            Document doc= indexSearcher.doc(scoreDoc.doc);
            //把Document转换成title
            Article article = AritcleDocumentUtils.documentToArticle(doc);
            list.add(article);
        }
        return new SearchResult<Article>(count,list);
    }
}
