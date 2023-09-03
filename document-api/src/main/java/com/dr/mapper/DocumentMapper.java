package com.dr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dr.bean.Document;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 文件Mapper
 * @author: whq
 * @date 2023-2-9 20:29:42
 */
@Mapper
public interface DocumentMapper extends BaseMapper<Document> {
}
