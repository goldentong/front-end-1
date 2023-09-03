package com.dr.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dr.bean.Role;

/**
 * @description: 角色service
 * @author: whq
 * @date 2022-12-4 12:54:33
 */
public interface RoleService extends IService<Role> {

    /**
     * @description: 分页查询用户信息
     * @param: page 分页数据
     * @param: keyWord 关键字
     */
    Page<Role> getPageList(Page page, String keyWord);

    /**
     * @description: 新增或编辑角色
     * @param: role 角色信息
     */
    void saveOrUpdateData(Role role);

    /**
     * @description: 删除角色
     * @param: id 角色id
     */
    void deleteData(Long id);
}
