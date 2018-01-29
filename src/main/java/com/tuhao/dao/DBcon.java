package com.tuhao.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 链接数据库
 *
 * @author FaceFeel
 * @create 2017-09-08 13:47
 */

public class DBcon  {

    public static SqlSession getSqlsession() throws IOException {

        //通过配置文件获取到数据库链接信息
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        //通过配置信息构建一个SqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过sqlSession工厂打开一个数据库会话
        return sqlSessionFactory.openSession();
    }
}
