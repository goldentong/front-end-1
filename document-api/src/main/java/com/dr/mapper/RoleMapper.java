package com.dr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dr.bean.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 角色Mapper
 * @author: whq
 * @date 2022-12-3 16:56:28
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
