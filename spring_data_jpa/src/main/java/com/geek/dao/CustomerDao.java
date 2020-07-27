package com.geek.dao;

import com.geek.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 只需要编写 dao 层接口，不需要编写 dao 层实现类。
 * <p>
 * dao 规范。
 * + 需要继承两个接口：Jpa
 * + 需要提供相应的泛型。
 * JpaRepository<操作的实体类类型，实体类中主键属性的类型>。
 * ~ 封装了基本 CRUD 操作。
 * JpaSpecificationExecutor<操作的实体类类型>
 * ~ 封装了复杂查询（分页...）。
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

}
