package com.dr.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dr.bean.Menu;
import com.dr.bean.PageResponse;
import com.dr.bean.Response;
import com.dr.bean.Role;
import com.dr.service.MenuService;
import com.dr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 菜单controller
 * @author: whq
 * @date 2022-12-5 16:51:32
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * @description: 获取所有菜单信息
     */
    @GetMapping("/all")
    public Response getAll() {
        List<Menu> menus = menuService.list();
        return PageResponse.ok(menus);
    }

    /**
     * @description: 查询菜单信息
     */
    @GetMapping
    public Response getList() {
        List<Menu> menus = menuService.getList();
        return Response.ok(menus);
    }

    /**
     * @description: 查询菜单信息 - 带权限
     * @param: roleIds 角色id
     */
    @GetMapping("/permission")
    public Response getPermissionList(@RequestParam String roleIds) {
        // 参数校验
        if (StringUtils.isEmpty(roleIds)) {
            Response.error("参数丢失");
        }
        List<Menu> menus = menuService.getPermissionList(roleIds);
        return Response.ok(menus);
    }

    /**
     * @description: 新增或编辑菜单
     * @param: menu 菜单信息
     */
    @PutMapping
    public Response updateData(@RequestBody Menu menu) {
        // 参数校验
        if (BeanUtil.isEmpty(menu)) {
            return Response.error("参数丢失");
        }
        menuService.updateData(menu);
        return Response.ok();
    }
}
