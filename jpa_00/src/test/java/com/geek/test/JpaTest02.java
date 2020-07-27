package com.geek.test;

import com.geek.domain.Customer;
import com.geek.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest02 {

    /**
     * 测试 jpa 的保存。
     * <p>
     * 加载配置文件创建工厂（实体管理器工厂）对象。
     * 通过实体管理器工厂获取实体管理器。
     * 获取事务对象，开启事务。
     * 完成增删改查操作。
     * 提交事务。
     * 释放资源。
     */
    @Test
    public void testSave() {
        // 加载配置文件创建工厂（实体管理器工厂）对象。
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJPA");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityManager entityManager = JpaUtils.getEntityManager();

        // 获取事务对象，开启事务。
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();// 开启事物。

//        transaction.commit();
//        transaction.rollback();

        // 完成增删改查操作。
        Customer customer = new Customer();// 模拟客户。
        customer.setCustName("李");
        customer.setCustAddress("武汉");

        // 保存。
        entityManager.persist(customer);

        // 提交事务。
        transaction.commit();

        // 释放资源。
        entityManager.close();
//        entityManagerFactory.close();
    }
}
