//package com.tuhao.tool;
//
//import com.google.common.collect.Maps;
//
///**
// * Created By SeanDragon
// * At 2016年11月25日, PM 01:26:21
// */
//public class ToolPageInfo {
//
//    public static final int DEFAULT_SIZE = 20;
//
//    public static PageInfo valid(PageInfo pageInfo) {
//        if (pageInfo == null) {
//            pageInfo = new PageInfo();
//            pageInfo.setPageIndex(0);
//            pageInfo.setPageSize(DEFAULT_SIZE);
//            DateFromTo dateFromTo = new DateFromTo();
//            pageInfo.setDateFromTo(dateFromTo);
//            return pageInfo;
//        }
//
//        if (pageInfo.getSortMap() == null) {
//            pageInfo.setSortMap(Maps.newHashMap());
//        }
//
//        if (pageInfo.getPageIndex() != 0) pageInfo.setPageIndex(pageInfo.getPageIndex() - 1);
//        if (pageInfo.getPageSize() == 0) pageInfo.setPageSize(DEFAULT_SIZE);
//
//        return pageInfo;
//    }
//}
