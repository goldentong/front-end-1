package com.dr.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dr.bean.User;

/**
 * @description: 用户service
 * @author: whq
 * @date 2022-12-3 20:34:32
 */
public interface UserService extends IService<User> {

    /**
     * @description: 登录
     * @param: user 用户信息
     */
    User login(User user);

    /**
     * @description: 分页查询用户信息
     * @param: page 分页数据
     * @param: keyWord 关键字
     */
    Page<User> getPageList(Page page, String keyWord);

    /**
     * @description: 新增或编辑用户
     * @param: user 用户信息
     */
    void saveOrUpdateData(User user);
}
