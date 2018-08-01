package cn.leon.entity;

import java.util.List;

/**
 * Created by Happy on 2017-11-30.
 */

/**
 * 查询结果集
 * @param <T>  T：占位： Article  评论  文章分类
 */
public class SearchResult<T> {
    //进行高度封装
    private int count;
    private List<T> list;

    public SearchResult(int count, List<T> list) {
        this.count = count;
        this.list = list;
    }

    public SearchResult() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
