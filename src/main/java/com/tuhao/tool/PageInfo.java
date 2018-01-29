//package com.tuhao.tool;
//import com.google.common.base.MoreObjects;
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 分页用
// */
//public class PageInfo implements Serializable {
//
//    //每页多少个数据
//    private int pageSize;
//    private Map<String, Integer> sortMap;
//    //第几页(是0就是1)
//    private int pageIndex;
//    private DateFromTo dateFromTo;
//    private FromTo fromTo;
//    //b-jui orders 暂时冗余 后期看情况去除！
//    private String orders;
//
//    public PageInfo() {
//        this.pageIndex = 1;
//        this.sortMap = new HashMap<>();
//        this.pageSize = ToolPageInfo.DEFAULT_SIZE;
//    }
//
//    @Override
//    public String toString() {
//        return MoreObjects.toStringHelper(this)
//                .add("pageSize", pageSize)
//                .add("sortMap", sortMap)
//                .add("pageIndex", pageIndex)
//                .add("dateFromTo", dateFromTo)
//                .add("fromTo", fromTo)
//                .add("orders", orders)
//                .toString();
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public PageInfo setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//        return this;
//    }
//
//    public Map<String, Integer> getSortMap() {
//        return sortMap;
//    }
//
//    public PageInfo setSortMap(Map<String, Integer> sortMap) {
//        this.sortMap = sortMap;
//        return this;
//    }
//
//    public int getPageIndex() {
//        return pageIndex;
//    }
//
//    public PageInfo setPageIndex(int pageIndex) {
//        this.pageIndex = pageIndex;
//        return this;
//    }
//
//    public DateFromTo getDateFromTo() {
//        return dateFromTo;
//    }
//
//    public PageInfo setDateFromTo(DateFromTo dateFromTo) {
//        this.dateFromTo = dateFromTo;
//        return this;
//    }
//
//    public PageInfo maxPageInfo() {
//        this.pageIndex = 1;
//        this.sortMap = new HashMap<>();
//        this.pageSize = Integer.MAX_VALUE;
//        return this;
//    }
//
//    public FromTo getFromTo() {
//        return fromTo;
//    }
//
//    public PageInfo setFromTo(FromTo fromTo) {
//        this.fromTo = fromTo;
//        return this;
//    }
//
//    public String getOrders() {
//        return orders;
//    }
//
//    public PageInfo setOrders(String orders) {
//        this.orders = orders;
//        return this;
//    }
//
//    public static PageInfo getMax() {
//        return new PageInfo().maxPageInfo();
//    }
//}
