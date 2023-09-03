package com.dr.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dr.bean.PageResponse;
import com.dr.bean.Response;
import com.dr.bean.Role;
import com.dr.bean.User;
import com.dr.service.RoleService;
import com.dr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 角色controller
 * @author: whq
 * @date 2022-12-4 12:53:33
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @description: 获取所有角色信息
     */
    @GetMapping("/all")
    public Response getAll() {
        List<Role> roles = roleService.list();
        return PageResponse.ok(roles);
    }

    /**
     * @description: 分页查询角色信息
     * @param: page 页码
     * @param: limit 页大小
     * @param: keyWord 关键字
     */
    @GetMapping
    public PageResponse getPageList(@RequestParam(required = false, defaultValue = "1") long page,
                                @RequestParam(required = false, defaultValue = "10") long size,
                                String keyWord) {
        // 分页查询
        Page<Role> pageList = roleService.getPageList(new Page<>(page, size), keyWord);
        return PageResponse.ok(pageList.getRecords(), pageList.getTotal());
    }

    /**
     * @description: 新增或编辑角色
     * @param: role 角色信息
     */
    @PostMapping
    public Response saveOrUpdateData(@RequestBody Role role) {
        // 参数校验
        if (BeanUtil.isEmpty(role)) {
            return Response.error("参数丢失");
        }
        roleService.saveOrUpdateData(role);
        return Response.ok();
    }

    /**
     * @description: 删除角色
     * @param: id 角色
     */
    @DeleteMapping("/{id}")
    public Response deleteData(@PathVariable Long id) {
        // 参数校验
        if (id == null) {
            return Response.error("参数丢失");
        }
        // 执行删除
        roleService.deleteData(id);
        return Response.ok();
    }
}
