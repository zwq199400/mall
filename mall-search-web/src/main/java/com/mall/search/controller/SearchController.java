package com.mall.search.controller;

import com.mall.common.pojo.SearchResult;
import com.mall.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zwq
 * @date 2018/12/3 15:28
 */
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Value("${SEARCH_RESULT_ROWS}")
    private Integer pageRows;

    @RequestMapping("/search")
    public String search(String keyword, @RequestParam(defaultValue="1") Integer page, Model model) throws Exception {
        //需要转码
        keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
        //调用Service查询商品信息
        SearchResult result = searchService.search(keyword, page, pageRows);
        //把结果传递给jsp页面
        model.addAttribute("query", keyword);
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("recordCount", result.getRecordCount());
        model.addAttribute("page", page);
        model.addAttribute("itemList", result.getItemList());
        //返回逻辑视图
        return "search";
    }


}
