package com.geek.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 解决实体管理器工厂的浪费资源和耗时的问题。
 * 通过静态代码块的形式，当程序第一次访问此工具类时，创建一个公共的实体管理器工厂对象。
 */
public class JpaUtils {

    private static EntityManagerFactory entityManagerFactory;

    static {
        // 加载配置文件。创建 EntityManagerFactory。
        entityManagerFactory = Persistence.createEntityManagerFactory("myJPA");
    }


    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
