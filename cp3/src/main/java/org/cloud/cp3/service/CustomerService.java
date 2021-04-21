package org.cloud.cp3.service;


import com.cloud.framework.annotation.Service;
import org.cloud.cp3.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 */
@Service
public class CustomerService {

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        return null;
//        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
//        return DatabaseHelper.queryEntity(Customer.class, sql, id);
        return null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
//        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
        return true;
    }


    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
//        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
        return true;
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
//        return DatabaseHelper.deleteEntity(Customer.class, id);
        return true;
    }
}
