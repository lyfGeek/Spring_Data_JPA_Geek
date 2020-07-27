package com.geek.test;

import com.geek.domain.Customer;
import com.geek.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    /**
     * 改。
     */
    @Test
    public void testMerge() {
        // 通过工具类获取 EntityManager。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 增删改查。~改。（实体管理器）。
        Customer customer = entityManager.find(Customer.class, 2L);
        // 更新。
        customer.setCustIndustry("java 开发。");
        entityManager.merge(customer);// 参数需要一个 Object。

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }

    /**
     * 根据 id 删除。
     */
    @Test
    public void testRemove() {
        // 通过工具类获取 EntityManager。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 增删改查。~根据 id 删除。（实体管理器）。
        Customer customer = entityManager.find(Customer.class, 1L);
        entityManager.remove(customer);// 参数需要一个 Object。

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }

    /**
     * 根据 id 查询。
     */
    @Test
    public void testFindByIdReference() {
        // 通过工具类获取 EntityManager。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 增删改查。~根据 id 查询。（实体管理器）。
        try {
            Object o = entityManager.getReference(Class.forName("com.geek.domain.Customer"), 1L);
            System.out.println("o = " + o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }

    /**
     * 根据 id 查询。
     */
    @Test
    public void testFindById() {
        // 通过工具类获取 EntityManager。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 增删改查。~根据 id 查询。（实体管理器）。
        try {
            Object o = entityManager.find(Class.forName("com.geek.domain.Customer"), 1L);
            System.out.println("o = " + o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }

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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJPA");
//            <persistence-unit name="myJPA" transaction-type="RESOURCE_LOCAL">

        // 获取 EntityManager 对象。
        // 通过实体管理器工厂获取实体管理器。
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // 内部维护了数据库信息。
        // 内部维护了缓存信息。
        // 内部维护了所有的实体管理器对象。
        // 创建 EntityManagerFactory 的过程中会根据配置创建数据库表。
        // ——>
        // EntityManagerFactory 的创建过程比较浪费资源。
        // 线程安全的对象。
        //      多个线程访问同一个 EntityManagerFactory 不会有线程安全问题。
        // ——>
        // 创建一个公共的 EntityManagerFactory 对象。
        // 静态代码块。

//        entityManager.persist();
//        entityManager.merge();
//        entityManager.remove();
//        entityManager.find();
//        entityManager.getReference();// 根据 id 查询，

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
        entityManagerFactory.close();
    }
}
