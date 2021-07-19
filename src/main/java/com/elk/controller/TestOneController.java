package com.elk.controller;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestOneController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @GetMapping("/testone/one")
    public Object one(){
        return "helloWorld!!!!33333";
    }

    @GetMapping("/testone/two")
    public Object two(){
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("name","Jack"));
        SearchRequest searchRequest = new SearchRequest("employee");
        searchRequest.source(searchSourceBuilder);
        try {
            return restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//            searchResponse.getHits().forEach(i -> {
//                String jsonString = i.getSourceAsString();
//                //使用fastjson将json对象转化为model
//                EsGoodsModel esGoodsModel = JSONObject.parseObject(jsonString,EsGoodsModel.class);
//            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



}
