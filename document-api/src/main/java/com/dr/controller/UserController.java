package com.dr.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dr.bean.PageResponse;
import com.dr.bean.Response;
import com.dr.bean.User;
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

/**
 * @description: 用户controller
 * @author: whq
 * @date 2022-12-3 16:56:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @description: 登录
     * @param: user 用户信息
     */
    @PostMapping("/login")
    public Response login(@RequestBody User user) {
        // 参数校验
        if (BeanUtil.isEmpty(user)) {
            return Response.error("参数丢失");
        }
        // 校验账号与密码
        if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword())) {
            return Response.error("参数丢失");
        }
        User result = userService.login(user);
        if (BeanUtil.isEmpty(result)) {
            return Response.error("登录失败");
        }
        return Response.ok(result);
    }


    /**
     * @description: 分页查询用户信息
     * @param: page 页码
     * @param: limit 页大小
     * @param: keyWord 关键字
     */
    @GetMapping
    public PageResponse getPageList(@RequestParam(required = false, defaultValue = "1") long page,
                                @RequestParam(required = false, defaultValue = "10") long size,
                                String keyWord) {
        // 分页查询
        Page<User> pageList = userService.getPageList(new Page<>(page, size), keyWord);
        return PageResponse.ok(pageList.getRecords(), pageList.getTotal());
    }

    /**
     * @description: 新增或编辑用户
     * @param: user 用户信息
     */
    @PostMapping
    public Response saveOrUpdateData(@RequestBody User user) {
        // 参数校验
        if (BeanUtil.isEmpty(user)) {
            return Response.error("参数丢失");
        }
        userService.saveOrUpdateData(user);
        return Response.ok();
    }

    /**
     * @description: 删除用户
     * @param: id 用户id
     */
    @DeleteMapping("/{id}")
    public Response deleteData(@PathVariable Long id) {
        // 参数校验
        if (id == null) {
            return Response.error("参数丢失");
        }
        // 执行删除
        userService.removeById(id);
        return Response.ok();
    }
}
