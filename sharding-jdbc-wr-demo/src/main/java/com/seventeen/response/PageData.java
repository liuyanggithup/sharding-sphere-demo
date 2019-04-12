package com.seventeen.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础分页数据
 * @author seventeen
 * @date 2018/11/2
 */

@ApiModel
public class PageData<T> {

    @ApiModelProperty(value = "总数据量")
    private Integer totalCount;

    @ApiModelProperty(value = "总页数")
    private Integer pageCount;

    @ApiModelProperty(value = "每页大小")
    private int page;

    @ApiModelProperty(value = "是否有下一页,true：是 false：否")
    private Boolean hasNext;

    @ApiModelProperty(value = "结果集(List对象)")
    private List<T> list;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getHasNext() {
        if (hasNext != null) {
            return hasNext;
        }

        return list != null && list.size() >= page;
    }

}
