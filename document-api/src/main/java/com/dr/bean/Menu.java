package com.dr.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * @description: 菜单实体类
 * @author: whq
 * @date 2022-12-5 15:56:20
 */
@Data
public class Menu {
    // 主键
    @TableId(type = IdType.AUTO)
    private Long id;
    // 菜单名
    private String name;
    // 编码
    private String code;
    // 父级id
    private Long parentId;
    // 排序值
    private Integer sort;
    // 备注
    private String remark;
    // 子集
    @TableField(exist = false)
    private List<Menu> children;
}
