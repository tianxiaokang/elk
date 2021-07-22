package com.elk.Dao;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.io.stream.ByteBufferStreamInput;
import org.elasticsearch.common.io.stream.StreamInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 索引操作
 */
@Component
public class Index {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     * @param name
     * @return
     * @throws IOException
     */
    public CreateIndexResponse create(String name) throws IOException {
        // 1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest(name);
        // 2、客户端执行请求 IndicesClient,请求后获得响应
        return restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 判断索引是否存在
     * @param name
     * @return
     * @throws IOException
     */
    public Boolean exist(String name) throws IOException {
        ByteBufferStreamInput index_name= new ByteBufferStreamInput(ByteBuffer.wrap(name.getBytes()));
        GetIndexRequest request = new GetIndexRequest(index_name);
        return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    }
}
