package com.tick.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private SqlSessionFactory sessionFactory = null;

    MybatisUtil() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis_config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public SqlSession getSession() {
        return sessionFactory.openSession(true);
    }
}