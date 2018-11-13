package com.shihu.demo.springboot.elasticsearch.service.impl;

import com.shihu.demo.springboot.elasticsearch.model.User;
import com.shihu.demo.springboot.elasticsearch.repository.UserRepository;
import com.shihu.demo.springboot.elasticsearch.service.UserPageService;
import org.elasticsearch.common.lucene.search.function.FiltersFunctionScoreQuery;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPageServiceImpl  implements UserPageService {
    /* 分页参数 */
    Integer DEFAULT_PAGE_SIZE = 50;          // 每页数量
    Integer DEFAULT_PAGE_NUMBER = 0; // 默认当前页码
    /* 搜索模式 */
    Float  MIN_SCORE = 10.0F;      // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> searchCity(Integer pageNumber, Integer pageSize, String searchContent) {

        // 校验分页参数
        if (pageSize == null || pageSize <= 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        if (pageNumber == null || pageNumber < DEFAULT_PAGE_NUMBER) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        // 构建搜索查询
        SearchQuery searchQuery = getUserSearchQuery(pageNumber,pageSize,searchContent);


        Page<User> userPage = userRepository.search(searchQuery);
        return userPage.getContent();
    }



    /**
     * 根据搜索词构造搜索查询语句
     *
     * 代码流程：
     *      - 权重分查询
     *      - 短语匹配
     *      - 设置权重分最小值
     *      - 设置分页参数
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    private SearchQuery getUserSearchQuery(Integer pageNumber, Integer pageSize, String searchContent) {
        // 短语匹配到的搜索词，求和模式累加权重分
        // 权重分查询 https://www.elastic.co/guide/cn/elasticsearch/guide/current/function-score-query.html
        //   - 短语匹配 https://www.elastic.co/guide/cn/elasticsearch/guide/current/phrase-matching.html
        //   - 字段对应权重分设置，可以优化成 enum
        //   - 由于无相关性的分值默认为 1 ，设置权重分最小值为 10

        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        FunctionScoreQueryBuilder functionScoreQueryBuilder=QueryBuilders.functionScoreQuery(new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
            new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchPhraseQuery("name",
                    searchContent),ScoreFunctionBuilders.weightFactorFunction(1000)),
           // new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchPhraseQuery("age",
            //        searchContent),ScoreFunctionBuilders.weightFactorFunction(500)),
            new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchPhraseQuery("birthday",
                    searchContent),ScoreFunctionBuilders.weightFactorFunction(100)),

        }).scoreMode(FiltersFunctionScoreQuery.ScoreMode.SUM).setMinScore(MIN_SCORE);
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }
}
