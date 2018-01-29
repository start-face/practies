//package com.tuhao.tool;
//import com.jfinal.plugin.IPlugin;
//import org.asyou.mongo.base.MongoConfig;
//import org.asyou.mongo.base.MongoManager;
//
///**
// * @author SeanDragon
// *         Create By 2017-05-03 9:51
// */
//public class MongoPlugin implements IPlugin {
//
//    private MongoConfig[] mongoConfig;
//
//    private MongoPlugin() {
//    }
//
//    public MongoPlugin(MongoConfig... configs) {
//        mongoConfig = configs;
//    }
//
//    @Override
//    public boolean start() {
//        try {
//            return MongoManager.putMongoConfig(mongoConfig);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("初始化Mongo插件失败！");
//        }
//    }
//
//    @Override
//    public boolean stop() {
//        return true;
//    }
//}
