package com.mall.search.service;


import com.mall.common.pojo.SearchResult;

/**
 * @author zwq
 * @date 2018/11/29 10:51
 */
public interface SearchService {

    SearchResult search(String keyword, int page, int rows)  throws Exception;

}
