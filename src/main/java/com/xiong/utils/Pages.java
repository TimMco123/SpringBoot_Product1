package com.xiong.utils;

import lombok.Data;

@Data
public class Pages {
    private Integer currentPage;//当前页
    private Integer pageSize;//页面容量
    private Integer countPage;//总记录数
    private Integer totalPage;//总页数
    private Integer prePage;//上一页
    private Integer nextPage;//下一页

    public Pages(Integer currentPage, Integer pageSize, Integer countPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.countPage = countPage;
    }

    //计算总页数
    public Integer getTotalPage() {
        if (getCountPage() % getPageSize() == 0) {
            return getCountPage() / getPageSize();
        } else {
            return getCountPage() / getPageSize() + 1;
        }
    }

    //上一页
    public Integer getPrePage() {
        if (getCurrentPage() <= 1) {
            return 1;
        } else {
            return getCurrentPage() - 1;
        }
    }

    //下一页
    public Integer getNextPage() {
        if (getCurrentPage() >= getTotalPage()) {
            return getTotalPage();
        } else {
            return getCurrentPage() + 1;
        }
    }
}
