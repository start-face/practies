//package com.tuhao.tool;
//import com.google.common.collect.Maps;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.jfinal.kit.PropKit;
//import com.jfinal.kit.StrKit;
//import org.asyou.mongo.Count;
//import org.asyou.mongo.FindMany;
//import org.asyou.mongo.Page;
//import org.asyou.mongo.Update;
//import org.asyou.mongo.dao.IMongoAdapter;
//import org.asyou.mongo.dao.MongoAdapter;
//import org.asyou.mongo.wrapper.DateFromTo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import pro.tools.data.text.ToolJson;
//import pro.tools.data.text.ToolStr;
//import java.lang.reflect.Field;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///**
// * mongo的工具类
// *
// * @author SeanDragon Create By 2017-05-02 10:35
// */
//@SuppressWarnings("unchecked")
//public class ToolMongo {
//
//    private static final Logger LOG = LoggerFactory.getLogger(ToolMongo.class);
//
//    public static <T> T insertOne(T data) {
//        try {
//            if (Factory.getAdapter().insertOne(data) == 0L) {
//                return data;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
//
//    public static <T> List<T> insertMany(List<T> dataList) {
//        try {
//            if (Factory.getAdapter().insertMany(dataList) == 0L) {
//                return dataList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
//
//    public static <T> boolean deleteOne(T data) {
//        try {
//            Factory.getAdapter().deleteOne(data);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    private static <T> boolean deleteMany(T data) {
//        try {
//            Factory.getAdapter().deleteMany(data);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static <T> boolean updateOne(T queue, T data) {
//        try {
//            Update.Result result = Factory.getAdapter().updateOne(queue, data);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static <T> boolean updateMany(T queue, T data) {
//        try {
//            Update.Result result = Factory.getAdapter().updateMany(queue, data);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //region find
//
//    //region common
//    public static <T> T findOne(T t) {
//        return Factory.getAdapter().findOne(t);
//    }
//
//    public static <T> List<T> findMany(T t) {
//        return findMany(t, new PageInfo(), false, false);
//    }
//
//    public static <T> List<T> findMany(T t, PageInfo pageInfo) {
//        return findMany(t, pageInfo, false, false);
//    }
//
//    public static <T> List<T> findMany(T t, boolean contain, boolean or) {
//        return findMany(t, new PageInfo(), contain, or);
//    }
//
//    public static <T> List<T> findMany(T t, PageInfo pageInfo, boolean contain, boolean or) {
//        return findPage(t, pageInfo, contain, or).getList();
//    }
//    //endregion
//
//    //region not
//    public static <T> List<T> findMany(T t, boolean not) {
//        return findMany(t, new PageInfo(), false, false, not);
//    }
//
//    public static <T> List<T> findMany(T t, PageInfo pageInfo, boolean not) {
//        return findMany(t, pageInfo, false, false, not);
//    }
//
//    public static <T> List<T> findMany(T t, boolean contain, boolean or, boolean not) {
//        return findMany(t, new PageInfo(), contain, or, not);
//    }
//
//    public static <T> List<T> findMany(T t, PageInfo pageInfo, boolean contain, boolean or, boolean not) {
//        return findPage(t, pageInfo, contain, or, not).getList();
//    }
//    //endregion
//
//    //region common
//    public static <T> Page<T> findPage(T t) {
//        return findPage(t, new PageInfo(), false, false);
//    }
//
//    public static <T> Page<T> findPage(T t, PageInfo pageInfo) {
//        return findPage(t, pageInfo, false, false);
//    }
//
//    public static <T> Page<T> findPage(T t, PageInfo pageInfo, boolean contain, boolean or) {
//        pageInfo = ToolPageInfo.valid(pageInfo);
//
//        Map<String, Integer> sortMap = pageInfo.getSortMap();
//        String sortStr = ToolJson.mapToJson(sortMap);
//
//        FindMany findMany = find(t, pageInfo.getDateFromTo(), contain, or);
//        if (!ToolStr.isBlank(sortStr)) findMany = findMany.sort(sortStr);
//
//        return findMany.page(pageInfo.getPageIndex(), pageInfo.getPageSize());
//    }
//    //endregion
//
//    //region not
//    public static <T> Page<T> findPage(T t, boolean not) {
//        return findPage(t, new PageInfo(), false, false, not);
//    }
//
//    public static <T> Page<T> findPage(T t, PageInfo pageInfo, boolean not) {
//        return findPage(t, pageInfo, false, false, not);
//    }
//
//    public static <T> Page<T> findPage(T t, PageInfo pageInfo, boolean contain, boolean or, boolean not) {
//        pageInfo = ToolPageInfo.valid(pageInfo);
//
//        Map<String, Integer> sortMap = pageInfo.getSortMap();
//        String sortStr = ToolJson.mapToJson(sortMap);
//
//        FindMany findMany = find(t, pageInfo.getDateFromTo(), contain, or, not);
//        if (!ToolStr.isBlank(sortStr)) findMany = findMany.sort(sortStr);
//
//        return findMany.page(pageInfo.getPageIndex(), pageInfo.getPageSize());
//    }
//    //endregion
//
//    //region common
//    public static <T> long count(T t) {
//        return count(t, new DateFromTo());
//    }
//
//    public static <T> long count(T t, DateFromTo dateFromTo) {
//        return count(t, dateFromTo, false, false);
//    }
//
//    public static <T> long count(T t, boolean contain, boolean or) {
//        return count(t, new DateFromTo(), contain, or);
//    }
//
//    public static <T> long count(T t, DateFromTo dateFromTo, boolean contain, boolean or) {
//        return count(t, dateFromTo, contain, or, false);
//    }
//    //endregion
//
//    //region not
//    public static <T> long count(T t, boolean not) {
//        return count(t, new DateFromTo(), not);
//    }
//
//    public static <T> long count(T t, DateFromTo dateFromTo, boolean not) {
//        return count(t, dateFromTo, false, false, not);
//    }
//    //endregion
//
//    //region 基础方法
//    public static <T> long count(T t, boolean contain, boolean or, boolean not) {
//        return count(t, new DateFromTo(), contain, or, not);
//    }
//
//    public static <T> long count(T t, DateFromTo dateFromTo, boolean contain, boolean or, boolean not) {
//        Count count = Factory.getAdapter().count(t);
//        if (dateFromTo != null) count = count.dateFromTo(dateFromTo);
//        if (contain) count = count.contain();
//        if (or) count = count.OR();
//        if (not) count = count.NOT();
//        return count.count();
//    }
//
//    public static <T> FindMany find(T t, DateFromTo dateFromTo, boolean contain, boolean or) {
//        return find(t, dateFromTo, contain, or, false);
//    }
//
//    public static <T> FindMany find(T t, DateFromTo dateFromTo, boolean contain, boolean or, boolean not) {
//        FindMany findMany = Factory.getAdapter().findMany(t);
//        if (dateFromTo != null) findMany = findMany.dateFromTo(dateFromTo);
//        if (contain) findMany = findMany.contain();
//        if (or) findMany = findMany.OR();
//        if (not) findMany = findMany.NOT();
//        return findMany;
//    }
//
//    public static String list2bson(final List objects) {
//        return Tool.list2str("[", "]", ",", objects);
//    }
//    //endregion
//
//    //endregion
//
//    private static final class Tool {
//
//        public static String list2bson(final List objects) {
//            return list2str("[", "]", ",", objects);
//        }
//
//        public static String list2str(final String start, final String end, final String sep, final List objects) {
//            StringBuilder stringBuilder = new StringBuilder(start);
//
//            objects.forEach(object -> {
//                if (object instanceof String) {
//                    stringBuilder.append("\"").append(object.toString()).append("\"").append(sep);
//                } else {
//                    stringBuilder.append(object).append(sep);
//                }
//            });
//            int i = stringBuilder.lastIndexOf(sep);
//            return stringBuilder.substring(0, i) + end;
//        }
//    }
//
//    public static class Factory {
//
//        private static IMongoAdapter instance;
//
//        public static IMongoAdapter getAdapter() {
//            if (instance == null) {
//                try {
//                    instance = new MongoAdapter(PropKit.get("config.mongo.id"));
//                } catch (Exception e) {
//                    String message = "初始化Mongo插件失败！";
//                    LOG.warn(message);
//                    throw new RuntimeException(message, e);
//                }
//            }
//            return instance;
//        }
//    }
//
//    /**
//     * @param object
//     *         model
//     *
//     * @return 将 一对一嵌套model 对象转成Map，Key=对象名.属性名.属性名...... 如 Key=userModel.userName..  Key=userModel.accountModel.money..
//     * Key=userModel.accountModel.xxModel.xxattr...  理论上可支持无限一对一嵌套
//     */
//    public static Map<String, Object> modelToAttrMaps(Object object) {
//        HashMap<String, Object> hashMap = Maps.newHashMap();
//        Map<String, Object> valueMap = ToolJson.modelToMap(object);
//        Class<?> aClass = object.getClass();
//        for (Field field : aClass.getDeclaredFields()) {
//            String name = field.getName();
//            String clzName = StrKit.firstCharToLowerCase(field.getDeclaringClass().getSimpleName()) + "." + name;
//            if (valueMap.containsKey(name)) {
//                Object val = valueMap.get(name);
//                if (val != null) {
//                    if (!(val instanceof JsonObject)) {
//                        hashMap.put(clzName, val);
//                    } else {
//                        hashMap.putAll(jsonObjectToMap(clzName, (JsonObject) val));
//                    }
//                }
//            }
//        }
//        return hashMap;
//    }
//
//    private static Map<String, Object> jsonObjectToMap(String clzName, JsonObject jsonObject) {
//        HashMap<String, Object> hashMap = Maps.newHashMap();
//        Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
//        for (Map.Entry<String, JsonElement> entry : entries) {
//            JsonElement value = entry.getValue();
//            String clzName1 = clzName + "." + entry.getKey();
//            if (!(value instanceof JsonObject)) {
//                hashMap.put(clzName1, value.getAsString().replaceAll("\"\\w+\"", ""));
//            } else {
//                JsonObject jsonObject1 = (JsonObject) value;
//                hashMap.putAll(jsonObjectToMap(clzName1, jsonObject1));
//            }
//        }
//        return hashMap;
//    }
//}
