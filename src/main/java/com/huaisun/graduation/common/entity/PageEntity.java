package com.huaisun.graduation.common.entity;

import lombok.Data;

@Data
public class PageEntity {

    /**
     * 表格大小
     */
    private Integer pageSize;

    /**
     * 表格当前页面
     */
    private Integer currentPage;

    /**
     * 总数
     */
    private Integer total;
}
