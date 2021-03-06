package org.cloud.cp3.controller;


import com.cloud.framework.annotation.Action;
import com.cloud.framework.annotation.Aspect;
import com.cloud.framework.annotation.Controller;
import com.cloud.framework.annotation.Inject;
import com.cloud.framework.bean.Data;
import com.cloud.framework.bean.Param;
import com.cloud.framework.bean.View;
import lombok.extern.slf4j.Slf4j;
import org.cloud.cp3.model.Customer;
import org.cloud.cp3.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理客户管理相关请求
 */
@Controller
@Slf4j
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * 进入 客户列表 界面
     */
    @Action("get:/customer")
    public View index(Param param) {
//        List<Customer> customerList = customerService.getCustomerList();
        List<Customer> customerList = new ArrayList<>();
        log.debug("/customer");
        System.out.println("/customer");
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    /**
     * 显示客户基本信息
     */
    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    /**
     * 进入 创建客户 界面
     */
    @Action("get:/customer_create")
    public View create(Param param) {
        return new View("customer_create.jsp");
    }

//    /**
//     * 处理 创建客户 请求
//     */
//    @Action("post:/customer_create")
//    public Data createSubmit(Param param) {
//        Map<String, Object> fieldMap = param.getFieldMap();
//        boolean result = customerService.createCustomer(fieldMap);
//        return new Data(result);
//    }

    /**
     * 进入 编辑客户 界面
     */
    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }
//
//    /**
//     * 处理 编辑客户 请求
//     */
//    @Action("put:/customer_edit")
//    public Data editSubmit(Param param) {
//        long id = param.getLong("id");
//        Map<String, Object> fieldMap = param.getFieldMap();
//        boolean result = customerService.updateCustomer(id, fieldMap);
//        return new Data(result);
//    }

    /**
     * 处理 删除客户 请求
     */
    @Action("delete:/customer_edit")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}