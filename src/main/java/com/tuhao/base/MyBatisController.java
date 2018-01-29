package com.tuhao.base;

import com.tuhao.dao.DBcon;
import com.tuhao.model.UserModel;
import com.tuhao.service.UserService;
import org.apache.ibatis.session.SqlSession;
import pro.tools.data.text.ToolRandoms;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * mybatis框架的测试类
 *
 * @author FaceFeel
 * @create 2017-09-08 11:59
 */

@WebServlet("/mybatis")
public class MyBatisController extends HttpServlet{

    private UserService userService = null;

    @Override
    public void init(){

        System.out.println("进入servlet初始化方法了!");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        UserModel userModel = new UserModel();
        userModel.setAge("12");
        userModel.setId(ToolRandoms.getRandomStr());
        userModel.setName("tom");
        userModel.setPassWord("123456");

        SqlSession sqlSession = DBcon.getSqlsession();
        UserService mapper = sqlSession.getMapper(UserService.class);
        try{
            Boolean aBoolean = mapper.insertOne(userModel);
            sqlSession.commit();
            System.err.println("持久化结果是:"+aBoolean);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy(){
        System.err.println("结束servlet会话,并且已经销毁!");
    }
}
