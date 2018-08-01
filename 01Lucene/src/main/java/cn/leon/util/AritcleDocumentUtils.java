package cn.leon.util;


import cn.leon.entity.Article;
import org.apache.lucene.document.*;
import org.apache.lucene.util.BytesRef;

/**
 * Created by Happy on 2017-11-30.
 */
public class AritcleDocumentUtils {
    //01.将Article转换成Document
    public static Document articleToDocument(Article article){
        Document document=new Document();
        document.add(new TextField("title",article.getTitle(), Field.Store.YES));
        document.add(new TextField("id",article.getId().toString(),Field.Store.YES));
        //排序依据  伪属性 排序：之前排序 ，原有属性作为排序依据。
        document.add(new NumericDocValuesField("sortid", article.getId()));
        document.add(new TextField("content",article.getContent(), Field.Store.YES));
        document.add(new SortedDocValuesField("Sorttitle",new BytesRef(article.getTitle().getBytes())));
        return document;
    }

    //02.把Document转换成Article
    public static Article  documentToArticle(Document document){
        Article article=new Article();
        article.setId(Integer.parseInt(document.get("id")));
        article.setTitle(document.get("title"));
        article.setContent(document.get("content"));
        return article;
    }
}
