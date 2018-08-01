package cn.leon;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by leon on 2018/7/27.
 */
public class EslaticSearch {
    public static final String indexname="myindex";
    public static final String documentType="product";
   public static TransportClient client=null;
    static {
        Settings settings=Settings.builder().put("cluster.name","my-es").put("client.transport.sniff",true).build();
            try {
                client=new PreBuiltTransportClient(settings)
                        .addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.208.5"),9300));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

    }

public static TransportClient getClient(){
        return client;
}

}

