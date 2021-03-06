package entity;

import java.util.List;

/**
 * Created by leon on 2018/3/1.
 */
public class page<T> {
    //总页数
    private int totalPage;
    //总记录数
    private int totalSize;
    //本页记录数
    private int pageSize;
    //当前页
    private int pageIndex;
    private List<T> lists;

    public int getTotalPage() {
        int total=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
        return total;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }


}
