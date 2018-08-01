package cn.leon;

import cn.leon.dao.ArticleDAO;
import cn.leon.entity.Article;
import cn.leon.entity.SearchResult;
import org.junit.Test;

/**
 * Created by Administrator
 * User:xcq
 * Date:2018/7/14
 * Time:17:43
 */
public class Demo20180714 {
    ArticleDAO articleDAO=new ArticleDAO();
    //添加
    @Test
    public void save(){
        Article article=new Article();
        article.setId(3);
        article.setTitle("他是谁？");
        article.setContent("他是你儿子");
        articleDAO.save(article);
    }

    @Test //批量添加数据到索引库
    public void saveMultiple(){
        for (int i=1;i<=25;i++){
            Article article=new Article();
            article.setId(i); //模拟数据
            article.setTitle("双12======"+i);
            article.setContent("双12就要疯狂购====="+i);
            //创建索引
            articleDAO.save(article);
        }
    }

    @Test //分页查询
    public void getArticlePagedList() throws Exception {
        SearchResult<Article> list = articleDAO.search("双12", 20, 10);
        for (Article article:list.getList()){
            System.out.println(article.getTitle());
        }
    }

}
