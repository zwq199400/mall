package com.mall.search.mapper;

import java.util.List;

import com.mall.common.pojo.SearchItem;

/**
 * @author zwq
 */
public interface ItemMapper {

	List<SearchItem> getItemList();

	SearchItem getItemById(long itemId);
}
