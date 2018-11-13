package com.mall.common.pojo;

import java.util.List;

/**
 * @author zwq
 * @date 2018/11/12 13:26
 */
public class EasyUIDataGridResult {
    private Integer total;

    private List<?> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}
