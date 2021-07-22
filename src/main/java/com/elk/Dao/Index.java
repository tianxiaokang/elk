package com.elk.Dao;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 索引操作
 */
@Component
public class Index {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public CreateIndexResponse create(String name) throws IOException {
        // 1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest(name);
        // 2、客户端执行请求 IndicesClient,请求后获得响应
        return restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }
}
