package com.dr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dr.bean.Menu;

import java.util.List;

/**
 * @description: 菜单service
 * @author: whq
 * @date 2022-12-5 15:59:33
 */
public interface MenuService extends IService<Menu> {


    /**
     * @description:查询菜单信息
     */
    List<Menu> getList();

    /**
     * @description: 查询菜单信息 - 带权限
     * @param: roleIds 角色id
     */
    List<Menu> getPermissionList(String roleIds);

    /**
     * @description: 编辑菜单
     * @param: menu 菜单信息
     */
    void updateData(Menu menu);
}
