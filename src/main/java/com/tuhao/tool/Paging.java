package com.tuhao.tool;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 规范化的分页对象
 *
 * @author SeanDragon Create By 2017-06-13 14:23
 */
public class Paging<T> implements Serializable {

    private int pageIndex;
    private int pageSize;
    private int perPageCount;
    private long totalCount;
    private String dateFrom;
    private String dateTo;
    private List<T> list;

    /**
     * 存放total数值
     */
    private Map totals;

    public int getPageIndex() {
        return pageIndex;
    }

    public Paging setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPerPageCount() {
        return perPageCount;
    }

    public Paging setPerPageCount(int perPageCount) {
        this.perPageCount = perPageCount;
        return this;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public Paging setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public Paging setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public String getDateTo() {
        return dateTo;
    }

    public Paging setDateTo(String dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public Paging setList(List<T> list) {
        this.list = list;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pageIndex", pageIndex)
                .add("pageSize", pageSize)
                .add("perPageCount", perPageCount)
                .add("totalCount", totalCount)
                .add("dateFrom", dateFrom)
                .add("dateTo", dateTo)
                .add("list", list)
                .toString();
    }

    public Paging(int pageIndex, int perPageCount, long totalCount) {
        this.pageIndex = pageIndex;
        this.perPageCount = perPageCount;
        this.totalCount = totalCount;
        this.count();
    }

    public Paging(int pageIndex, int perPageCount, long totalCount, List<T> list) {
        this.pageIndex = pageIndex;
        this.perPageCount = perPageCount;
        this.totalCount = totalCount;
        this.list = list;
        this.count();
    }

    private void count() {
        int mod = (int) (this.totalCount % (long) this.perPageCount);
        if (mod == 0) {
            this.pageSize = (int) (this.totalCount / (long) this.perPageCount);
        } else {
            this.pageSize = (int) (this.totalCount / (long) this.perPageCount) + 1;
        }

        if (this.pageIndex < 0) {
            this.pageIndex = 0;
        }
    }

    public Paging firstPage() {
        this.pageIndex = 0;
        this.count();
        return this;
    }

    public Paging lastPage() {
        this.pageIndex = this.pageSize - 1;
        this.count();
        return this;
    }

    public Paging nextPage() {
        ++this.pageIndex;
        this.count();
        return this;
    }

    public Paging prePage() {
        --this.pageIndex;
        this.count();
        return this;
    }

    public Paging gotoPage(int pageIndex) {
        this.pageIndex = pageIndex;
        this.count();
        return this;
    }

    public Map getTotals() {
        return totals;
    }

    public Paging setTotals(Map totals) {
        this.totals = totals;
        return this;
    }
}