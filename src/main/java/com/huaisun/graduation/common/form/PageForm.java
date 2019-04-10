package com.huaisun.graduation.common.form;

import lombok.Data;

@Data
public class PageForm {

    /**
     * 表格大小
     */
    private Integer pageSize;

    /**
     * 表格当前页面
     */
    private Integer currentPage;
}
