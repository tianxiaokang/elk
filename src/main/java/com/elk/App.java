package com.elk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchQuery("name","123"));
//        SearchRequest searchRequest = new SearchRequest("test_index");
//        searchRequest.source(searchSourceBuilder);
//        try {
//            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//            searchResponse.getHits().forEach(i -> {
//                String jsonString = i.getSourceAsString();
//                //使用fastjson将json对象转化为model
//                EsGoodsModel esGoodsModel = JSONObject.parseObject(jsonString,EsGoodsModel.class);
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
