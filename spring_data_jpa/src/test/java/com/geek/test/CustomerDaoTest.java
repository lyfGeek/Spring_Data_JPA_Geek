package com.geek.test;

import com.geek.dao.CustomerDao;
import com.geek.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)// 声明 Spring 提供的单元测试环境。
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据 id 查询。
     */
    @Test
    public void testFindOne() {
//        Customer customer = customerDao.findOne(3L);
        Optional<Customer> customer = customerDao.findById(1L);
        System.out.println("customer = " + customer);
    }

    /**
     * 保存或更新。
     * 根据传递的对象查询是否存在主键。
     * 如果没有 id 主键属性，保存。
     * 如果有 id 主键属性，根据 id 查询数据，更新数据。
     */
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setCustName("Geek 李");
        customer.setCustLevel("vip");
        customerDao.save(customer);
        // Hibernate: insert into cst_customer (cust_address, cust_industry, cust_level, cust_name, cust_phone, cust_source) values (?, ?, ?, ?, ?, ?)
    }

    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setCustId(3L);
        customer.setCustName("Geek");
        customer.setCustAddress("武汉");
        customer.setCustLevel("vip");
        customerDao.save(customer);
        // Hibernate: update cst_customer set cust_address=?, cust_industry=?, cust_level=?, cust_name=?, cust_phone=?, cust_source=? where cust_id=?
    }

    /**
     * 删除。
     */
    @Test
    public void testDelete() {
        customerDao.deleteById(6L);
        // Hibernate: select customer0_.cust_id as cust_id1_0_0_, customer0_.cust_address as cust_add2_0_0_, customer0_.cust_industry as cust_ind3_0_0_, customer0_.cust_level as cust_lev4_0_0_, customer0_.cust_name as cust_nam5_0_0_, customer0_.cust_phone as cust_pho6_0_0_, customer0_.cust_source as cust_sou7_0_0_ from cst_customer customer0_ where customer0_.cust_id=?
        //Hibernate: delete from cst_customer where cust_id=?
    }

    /**
     * 查询所有。
     */
    @Test
    public void testFindAll() {
        List<Customer> all = customerDao.findAll();
        all.forEach(System.out::println);
    }

}
