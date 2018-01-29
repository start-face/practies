//package com.tuhao.controller;
//
//import com.jfinal.aop.Duang;
//import com.jfinal.kit.PropKit;
//import com.jfinal.plugin.IPlugin;
//import com.tuhao.model.workflow.Node;
//import com.tuhao.model.workflow.Workflow;
//import com.tuhao.service.JsonService;
//import com.tuhao.service.JsonServiceImpl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class DataController extends HttpServlet {
//
//    private JsonService jsonService = Duang.duang(JsonServiceImpl.class);
//    private Logger logger = LoggerFactory.getLogger(DataController.class);
//
//    @Override
//    public void init() {
//        System.out.println("开始初始化！");
//
//        PropKit.use("init.properties");
//        getMongoPlugin().start();
//        System.err.println("完成初始化！");
//    }
//
//    @Override
//    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Workflow json = jsonService.getJson(2L);
//        String result=null;
//        for (Node rs:json.getNodeLinkedList()){
//            result = rs.getResult();
//        }
//
//        String method = request.getMethod();
//
//        request.getSession().setAttribute("json", result);
////        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().print(request);
//        request.getRequestDispatcher("success.jsp").forward(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("注销了servlet！");
//    }
//
//    public IPlugin getMongoPlugin() {
//
//        logger.info("初始化Mongo插件");
//        MongoConfig mongoConfig = new MongoConfig();
//        mongoConfig.setId(PropKit.get("config.mongo.id"));
//        mongoConfig.setHostName(PropKit.get("config.mongo.host"));
//        mongoConfig.setPort(PropKit.getInt("config.mongo.port"));
//        mongoConfig.setDatabaseName(PropKit.get("config.mongo.database"));
//        mongoConfig.setPoolSize(PropKit.getInt("config.mongo.poolSize"));
//        mongoConfig.setMaxWaitTime(PropKit.getInt("config.mongo.maxWaitTime"));
//        mongoConfig.setConnectTimeout(PropKit.getInt("config.mongo.connectTimeout"));
//        mongoConfig.setBlockSize(PropKit.getInt("config.mongo.blockSize"));
////        return new MongoPlugin(mongoConfig);
//        return null;
//    }
//}
