package com.dr.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @description: 角色实体类
 * @author: whq
 * @date 2022-12-3 16:51:43
 */
@Data
public class Role {
    // 主键
    @TableId(type = IdType.AUTO)
    private Long id;
    // 角色名
    private String name;
    // 备注
    private String remark;
    // 菜单id
    private String menuIds;
}
