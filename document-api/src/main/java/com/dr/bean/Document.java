package com.dr.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * @description: 人员档案实体类
 * @author: whq
 * @date 2023-2-9 20:23:06
 */
@Data
public class Document {
    // 主键
    @TableId(type = IdType.AUTO)
    private Long id;
    // 居民姓名
    private String name;
    // 居民照片
    private String pictureUrl;
    // 背景信息
    private String backInfo;
    // 语言ids
    private String languageIds;
    // 语言names
    private String languageNames;
    // 偏好ids
    private String favoriteIds;
    // 偏好names
    private String favoriteNames;
    // 创建时间
    private String createDate;
}
