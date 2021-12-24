package com.ay.kg.util;

/**
 * 分页参数类
 */
public class PageParam {
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 当前页有多少数据
     */
    private int pageSize;
    /**
     * 要查的字段(别名=model属性名)
     */
    private String sqlColumns;
    /**
     * 排序
     */
    private String sort;
    /**
     * 条件(json格式)
     */
    private String condition;

    public PageParam() {
    }

    public PageParam(int pageNum, int pageSize, String sort, String condition) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.sort = sort;
        this.condition = condition;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSqlColumns() {
        return sqlColumns;
    }

    public void setSqlColumns(String sqlColumns) {
        this.sqlColumns = sqlColumns;
    }

    public int getPageStart() {
        if (pageNum > 0) {
            return (pageNum - 1) * pageSize;
        }
        return pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
