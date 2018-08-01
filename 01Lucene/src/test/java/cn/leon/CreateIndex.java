package cn.leon;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.junit.Test;

/**
 * Created by leon on 2018/7/27.
 */
public class CreateIndex {

    @Test
    public void test01(){
        CreateIndexResponse response = EslaticSearch.getClient().admin().indices().prepareCreate(EslaticSearch.indexname).execute().actionGet();
        if(response.isAcknowledged()){
            System.out.println("ok");
        }else{
            System.out.println("no");
        }
    }
}
