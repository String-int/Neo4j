package com.ay.kg.util;

import java.util.List;

/**
 * 分页结果
 */
public class PageResult {

    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 当前页多少数据
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Integer total;
    /**
     * 记录
     */
    private List records;

    public PageResult() {
    }

    public PageResult(Integer pageNum, Integer pageSize, Integer total, List records) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.records = records;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }
}
