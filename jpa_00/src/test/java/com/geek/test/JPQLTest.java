package com.geek.test;

import com.geek.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * 测试 jpql 查询。
 */
public class JPQLTest {


    /**
     * 条件查询。
     * sql：SELECT * FROM new_schema.cst_customer where cust_name LIKE ?;
     * jpql：from Customer where custName like ?
     */
    @Test
    public void testCondition() {
        // 获取 EntityManager 对象。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // 查询总数。
        //  根据 jpql 语句创建 Query 对象。
        String jpql = "from Customer where custName like ?";
        Query query = entityManager.createQuery(jpql);// Query 对象才是执行 jpql 的对象。

        // 对象参数赋值。占位符参数。
        // 占位符位置。从 1 开始。
        query.setParameter(1, "李%");

        // 发送查询。并封装结果。（唯一）。
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println("o = " + o);
        }

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }

    /**
     * 分页查询。
     * sql：SELECT * FROM new_schema.cst_customer limit ?, ?;
     * jpql：from Customer
     */
    @Test
    public void testPage() {
        // 获取 EntityManager 对象。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // 查询总数。
        //  根据 jpql 语句创建 Query 对象。
        String jpql = "from Customer";
        Query query = entityManager.createQuery(jpql);// Query 对象才是执行 jpql 的对象。

        // 对象参数赋值。分页参数。
        // 起始索引。
        query.setFirstResult(0);// limit ?
//        query.setFirstResult(1);// limit ?, ?
        // 每页条数。
        query.setMaxResults(2);

        // 发送查询。并封装结果。（唯一）。
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println("o = " + o);
        }

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }

    /**
     * 统计总数。
     * sql：SELECT COUNT(cust_id) FROM new_schema.cst_customer;
     * jpql：select count(custId) from Customer
     */
    @Test
    public void testCount() {
        // 获取 EntityManager 对象。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // 查询总数。
        //  根据 jpql 语句创建 Query 对象。
        String jpql = "select count(custId) from Customer";
        Query query = entityManager.createQuery(jpql);// Query 对象才是执行 jpql 的对象。
        // 对象参数赋值。
        // 发送查询。并封装结果。（唯一）。
        Object singleResult = query.getSingleResult();
        System.out.println("singleResult = " + singleResult);

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }


    /**
     * 排序查询。（倒序）。
     * sql：SELECT * FROM new_schema.cst_customer ORDER BY cust_id DESC;
     * jpql：from Customer order by custId desc
     */
    @Test
    public void testOrders() {
        // 获取 EntityManager 对象。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // 查询全部。
        String jpql = "from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);// Query 对象才是执行 jpql 的对象。

        // 发送查询。并封装结果集。
        List resultList = query.getResultList();

        for (Object o : resultList) {
            System.out.println("o = " + o);
        }

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }

    /**
     * 查询全部。
     * <p>
     * jpql：from com.geek.domain.Customer
     * sql：SELECT * FROM new_schema.cst_customer;
     */
    @Test
    public void testFindAll() {
        // 获取 EntityManager 对象。
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 开启事务。
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // 查询全部。
        String jpql = "from com.geek.domain.Customer";
        Query query = entityManager.createQuery(jpql);// Query 对象才是执行 jpql 的对象。

        // 发送查询。并封装结果集。
        List resultList = query.getResultList();

        for (Object o : resultList) {
            System.out.println("o = " + o);
        }

        // 提交事务。
        tx.commit();
        // 释放资源。
        entityManager.close();
    }

}
